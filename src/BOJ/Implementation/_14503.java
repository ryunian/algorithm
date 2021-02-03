package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14503 {
    static int n, m, startX, startY, d, cnt = 0;
    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken())+1;
        startY = Integer.parseInt(st.nextToken())+1;
        d = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], 1);
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(startX, startY, d);
    }

    private static void solve(int x, int y, int dir) {
        // 1. 현재위치를 청소한다.
        if (map[x][y] == 0) {
            map[x][y] = -1;
            cnt++;
        }
        // 2.
        int ndir = dir == 0 ? 3 : dir - 1;
        int nx = x + dx[ndir];
        int ny = y + dy[ndir];

        if (map[nx][ny] == 0) {
            solve(nx, ny, ndir);
        } else if (map[x - 1][y] != 0 && map[x + 1][y] != 0 && map[x][y - 1] != 0 && map[x][y + 1] != 0) {
            x = x + dx[(dir + 2) % 4];
            y = y + dy[(dir + 2) % 4];
            if (map[x][y] != 1) {
                solve(x, y, dir);
            } else {
                System.out.println(cnt);
            }
        } else if (map[nx][ny] != 0) {
            solve(x, y, ndir);
        }
    }
}

