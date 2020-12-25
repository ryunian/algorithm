package BOJ.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 다른 풀이법 : 정점 a , b의 사이의 거리는
// ( root ~ a) + ( root ~ b ) - ( root ~ LCA(a,b) )*2 와 같다.
public class _1761 {
    static int n;
    static boolean[] visit;
    static int[] deep;
    static int[][][] parent;
    static ArrayList<Pair>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        parent = new int[n][21][2]; // 왜 21이지?
        deep = new int[n];
        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Pair(b, c));
            list[b].add(new Pair(a, c));
        }

        findDeepAsDFS(0, 0);
        makeParent();

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(parent[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(parent[i][j][1] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            solve(a, b);
        }
    }

    private static void solve(int a, int b) {
        int cntA = 0;
        int cntB = 0;
        if (deep[a] > deep[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = 20; i >= 0; i--) {
            if (deep[b] - deep[a] >= (1 << i)) {
                cntB += parent[b][i][1];
                b = parent[b][i][0];
            }
        }

        if (a != b) {
            for (int i = 20; i >= 0; i--) {
                if (parent[a][i][0] != parent[b][i][0]) {
                    cntA += parent[a][i][1];
                    a = parent[a][i][0];
                    cntB += parent[b][i][1];
                    b = parent[b][i][0];
                }
            }
            cntA += parent[a][0][1];
            cntB += parent[b][0][1];
        }
        System.out.println(cntA + cntB);
    }

    private static void makeParent() {
        for (int i = 1; i < 21; i++) {
            for (int j = 0; j < n; j++) {
                parent[j][i][0] = parent[parent[j][i - 1][0]][i - 1][0];
                if (parent[j][i - 1][0] != 0) {
                    parent[j][i][1] = parent[parent[j][i - 1][0]][i - 1][1] + parent[j][i - 1][1];
                }
            }
        }
    }

    private static void findDeepAsDFS(int x, int cnt) {
        visit[x] = true;
        deep[x] = cnt;
        for (Pair next : list[x]) {
            if (!visit[next.edge]) {
                parent[next.edge][0][0] = x;
                parent[next.edge][0][1] = next.dis;
                findDeepAsDFS(next.edge, cnt + 1);
            }
        }
    }

    private static class Pair {
        int edge;
        int dis;

        public Pair(int edge, int dis) {
            this.edge = edge;
            this.dis = dis;
        }
    }
}
