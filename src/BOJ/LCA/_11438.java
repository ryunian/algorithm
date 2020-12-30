package BOJ.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11438 {
    static int n;
    static boolean[] visit;
    static int[] deep;
    static int[][] parent;
    static ArrayList<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        // n이 최대 10만이기 때문에 2^20은 100만 이상의 수로 2^20번쨰 조상까지만 채워주더라도 충분하다
        parent = new int[n + 1][21];
        visit = new boolean[n + 1];
        deep = new int[n + 1];

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // init
        findDeep(1, 0);
        makeParent();


        // query
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(query(a, b)).append("\n");
        }

        // result
        System.out.println(sb.toString());
    }

    private static void findDeep(int cur, int cnt) {
        visit[cur] = true;
        deep[cur] = cnt;
        for (int next : list[cur]) {
            if (!visit[next]) {
                parent[next][0] = cur;
                findDeep(next, cnt + 1);
            }
        }

    }

    private static void makeParent() {
        for (int j = 1; j < 21; j++) {
            for (int i = 0; i <= n; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    private static int query(int a, int b) {
        if (deep[a] > deep[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = 20; i >= 0; i--) {
            if (deep[b] - deep[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }

        if(a != b){
            for(int i = 20; i>= 0; i--){
                if(parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];
                }
            }
            b = parent[b][0];
        }

        return b;
    }

}
