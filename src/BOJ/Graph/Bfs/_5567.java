package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        bfs(map, n);
    }

    private static void bfs(int[][] map, int n) {
        int[] visit = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        visit[1] = 1;
        queue.add(1);

        int res = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 자신의 친구와 친구의 친구 = 3
            if (visit[cur] == 3) {
                break;
            }

            for (int next = 1; next <= n; next++) {
                if (visit[next] == 0 && map[cur][next] == 1) {
                    visit[next] = visit[cur] + 1;
                    res++;
                    queue.add(next);
                }
            }
        }
        System.out.println(res);

    }
}
