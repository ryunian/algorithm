package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 등산로 조성
public class _1949 {
    static int n, k, res;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, arr[i][j]);
                }
            }
            res = 0;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == max) {
                        visit[i][j] = true;
                        dfs(i, j, 0, 1);
                        visit[i][j] = false;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }


    private static void dfs(int x, int y, int z, int depth) {
        res = Math.max(res, depth);
        int cur = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (visit[nx][ny]) continue;

            if (arr[nx][ny] < cur) {
                visit[nx][ny] = true;
                dfs(nx, ny, z, depth + 1);
                visit[nx][ny] = false;

            } else if (z == 0 && arr[nx][ny] - cur + 1 <= k) {
                visit[nx][ny] = true;
                int tmp = arr[nx][ny];
                arr[nx][ny] = cur - 1;
                dfs(nx, ny, z + 1, depth + 1);
                arr[nx][ny] = tmp;
                visit[nx][ny] = false;
            }
        }
    }
}
