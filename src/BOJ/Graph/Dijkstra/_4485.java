package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485 {
    static int n, INF = 987654321;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            arr = new int[n][n];
            dp = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    dp[j][k] = INF;
                }
            }


            int res = solve();
            sb.append("Problem ").append(i + 1 + ": ").append(res).append("\n");

        }
        System.out.print(sb.toString());
    }

    private static int solve() {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.num));
        queue.add(new Pair(0, 0, arr[0][0]));
        dp[0][0] = arr[0][0];

        int ret = -1;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            if(cur.x == n-1 && cur.y == n-1){
                ret = cur.num;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];


                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int num = cur.num + arr[nx][ny];

                if (dp[nx][ny] > num) {
                    dp[nx][ny] = num;
                    queue.add(new Pair(nx, ny, num));
                }
            }
        }
        return ret;

    }

    private static class Pair {
        int x;
        int y;
        int num;

        public Pair(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
