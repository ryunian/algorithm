package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽돌 꺠기
public class _5656 {
    static int n, w, h, res;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            int[][] arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res = Integer.MAX_VALUE;
            solve(0, arr);
            System.out.printf("#%d %d\n", tc, res);
        }
    }


    private static void solve(int cnt, int[][] arr) {
        if (cnt == n) {
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] != 0) count++;
                }
            }
            res = Math.min(count, res);
            return;
        }

        for (int i = 0; i < w; i++) {
            int[][] tmp = boom(i, arr);
            solve(cnt + 1, tmp);
        }
    }

    private static int[][] boom(int y, int[][] arr) {
        int[][] tmp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        int x = 0;
        while (x < h - 1 && arr[x][y] == 0) {
            x++;
        }
        dfs(x, y, tmp);
        down(tmp);
        return tmp;
    }

    private static void down(int[][] map) {
        for (int i = 0; i < w; i++) {
            int height = h - 1;
            int idx = h - 1;
            while (idx >= 0) {
                if (map[idx][i] != 0) {
                    int tmp = map[idx][i];
                    map[idx][i] = 0;
                    map[height][i] = tmp;
                    height--;
                }
                idx--;
            }
        }
    }

    private static void dfs(int x, int y, int[][] arr) {
        if (arr[x][y] == 0) return;
        int loop = arr[x][y];
        arr[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            for (int j = 0; j < loop - 1; j++) {
                nx = nx + dx[i];
                ny = ny + dy[i];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (arr[nx][ny] == 0) continue;
                dfs(nx, ny, arr);
            }
        }
    }
}
