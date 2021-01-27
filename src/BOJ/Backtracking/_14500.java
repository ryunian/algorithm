package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500 {
    static int n, m, res = 0;
    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i, j, 1, map[i][j]);
                visit[i][j] = false;
                solve2(i, j);
            }
        }
        System.out.println(res);
    }

    private static void solve(int x, int y, int cnt, int val) {
        if (cnt == 4) {
            res = Math.max(res, val);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visit[nx][ny]) continue;

            visit[nx][ny] = true;
            solve(nx, ny, cnt + 1, val + map[nx][ny]);
            visit[nx][ny] = false;
        }
    }

    private static void solve2(int x, int y) {
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        int wing = 4;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                wing--;
                continue;
            }
            if (wing == 2) return;

            min = Math.min(min, map[nx][ny]);
            sum += map[nx][ny];
        }
        if (wing == 4) sum -= min;
        res = Math.max(res, sum);
    }
}

