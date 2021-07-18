package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14218 {
    private static int n, m, INF = 987654321;
    private static int[] visit;
    private static ArrayList<Integer>[] list;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        visit = new int[n + 1];
        Arrays.fill(visit, INF);
        dfs(1, 0);

        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
            if (visit[a] > visit[b] + 1) {
                dfs(a, visit[b] + 1);
            } else if (visit[a] + 1 < visit[b]) {
                dfs(b, visit[a] + 1);
            }
            write();
        }
        System.out.print(sb.toString());
    }

    private static void write() {
        for (int i = 1; i <= n; i++) {
            int x = visit[i] == INF ? -1 : visit[i];
            sb.append(x + " ");
        }
        sb.append("\n");
    }

    private static void dfs(int idx, int cnt) {
        visit[idx] = cnt;
        for (int next : list[idx]) {
            if (visit[next] > cnt + 1) {
                dfs(next, cnt + 1);
            }
        }
    }
}
