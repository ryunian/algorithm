package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {
    private static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(solve(n, x1, y1, x2, y2));
        }
    }


    private static int solve(int n, int x1, int y1, int x2, int y2) {
        int[][] visit = new int[n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x1, y1));
        visit[x1][y1] = 1;
        int ret = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.x == x2 && cur.y == y2) {
                ret = visit[cur.x][cur.y] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visit[nx][ny] == 0) {
                    visit[nx][ny] = visit[cur.x][cur.y] + 1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
        return ret;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
