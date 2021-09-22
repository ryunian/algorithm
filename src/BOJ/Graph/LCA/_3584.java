package BOJ.Graph.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 가장 가까운 공통 조상
public class _3584 {
    static int n;
    static int[] visit;
    static int[][] parent;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            list = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            int[] arr = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
                arr[b]++;
            }
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            visit = new int[n + 1];
            parent = new int[n + 1][21];

            for (int i = 1; i <= n; i++) {
                if (arr[i] == 0) {
                    dfs(i, 1);
                    break;
                }
            }
            makeParent();
            sb.append(solve(x, y) + "\n");
        }
        System.out.print(sb.toString());
    }

    private static int solve(int x, int y) {
        if (visit[x] > visit[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        for (int i = 20; i >= 0; i--) {
            if (visit[y] - visit[x] >= (1 << i)) {
                y = parent[y][i];
            }
        }


        if (x != y) {
            for (int i = 20; i >= 0; i--) {
                if (parent[x][i] != parent[y][i]) {
                    x = parent[x][i];
                    y = parent[y][i];
                }
            }
            x = parent[x][0];
        }
        return x;
    }

    private static void makeParent() {
        for (int i = 1; i < 21; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    private static void dfs(int cur, int cnt) {
        visit[cur] = cnt;

        for (int next : list[cur]) {
            if (visit[next] == 0) {
                parent[next][0] = cur;
                dfs(next, cnt + 1);
            }
        }

    }
}
