package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);
    }

    private static void solve(int prev, int time) {
        int cnt = melt();
        if (cnt != 0) {
            solve(cnt, time + 1);
            return;
        }
        System.out.println(time);
        System.out.println(prev);
    }

    private static int melt() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visit[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        cnt++;
                    } else {
                        queue.add(new Pair(nx, ny));
                    }
                    visit[nx][ny] = true;

                }
            }
        }
        return cnt;
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
