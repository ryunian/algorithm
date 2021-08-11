package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가희의 고구마 먹방
public class _21772 {
    static int n, m, t, sx, sy, res;
    static char[][] arr;
    static boolean[][][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        int potato = 1;
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = tmp.charAt(j);
                arr[i][j] = c;
                if (c == 'G') {
                    sx = i;
                    sy = j;
                } else if (c == 'S') {
                    potato++;
                }
            }
        }
        visit = new boolean[n][m][potato];

        solve(sx, sy, 0, 0);
        System.out.println(res);
    }

    private static void solve(int x, int y, int cnt, int sum) {
        if (cnt == t) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (arr[nx][ny] == '#') continue;

            int nSum = sum + (arr[nx][ny] == 'S' ? 1 : 0);
            if (!visit[nx][ny][nSum]) {
                visit[nx][ny][nSum] = true;
                char c = arr[nx][ny];
                arr[nx][ny] = '.';
                solve(nx, ny, cnt + 1, nSum);
                arr[nx][ny] = c;
                visit[nx][ny][nSum] = false;
            }
        }
    }
}
