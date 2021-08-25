package BOJ.Graph.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 최소 공통 조상 ( LCA )
public class _11437 {
    static int n;
    static int[] deep;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    static int[][] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        deep = new int[n];
        visit = new boolean[n];
        list = new ArrayList[n];
        parent = new int[n][21];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[a].add(b);
            list[b].add(a);
        }
        dfs(0, 0);
        makeParent();
//        System.out.println();
//        for (int[] a : parent) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            solve(x, y);
        }
    }

    private static void solve(int x, int y) {
        // x와 y중 깊이가 더 깊은것을 y로 바꿈
        if (deep[x] > deep[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        // 서로의 깊이를 맞춰준다
        for (int i = 20; i >= 0; i--) {
            if (deep[y] - deep[x] >= (1 << i)) {
                y = parent[y][i];
            }
        }

        // x와 y 각각 부모로 올라간다
        if (x != y) {
            for (int i = 20; i >= 0; i--) {
                if (parent[x][i] != parent[y][i]) {
                    x = parent[x][i];
                    y = parent[y][i];
                }
            }
            x = parent[x][0];
        }
        System.out.println(x + 1);
    }

    private static void makeParent() {
        for (int i = 1; i < 21; i++) {
            for (int j = 0; j < n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    private static void dfs(int cur, int cnt) {
        visit[cur] = true;
        deep[cur] = cnt;

        for (int next : list[cur]) {
            if (!visit[next]) {
                parent[next][0] = cur;
                dfs(next, cnt + 1);
            }
        }
    }
}
