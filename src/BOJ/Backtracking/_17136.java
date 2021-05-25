package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136 {
    private static final int size = 10;
    private static int paperCnt, res = Integer.MAX_VALUE;
    private static int[] arr = {0, 1, 2, 3, 4};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[size][size];

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if (x == 1) paperCnt++;
            }
        }
        int[] visit = new int[5];
        solve(0, 0, paperCnt, 0, map, visit);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void solve(int x, int y, int remain, int cost, int[][] map, int[] visit) {
        if (x == size) {
            if (remain == 0) {
                res = Math.min(res, cost);
            }
            return;
        } else if (y >= size) {
            solve(x + 1, 0, remain, cost, map, visit);
            return;
        }
        if (map[x][y] == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (check(x, y, i, map) && visit[i] + 1 <= 5) {
                    int[][] tmp = cover(x, y, i, map);
                    int minus = (i + 1) * (i + 1);
                    visit[i] = visit[i] + 1;
                    solve(x, y + 1, remain - minus, cost + 1, tmp, visit);
                    visit[i] = visit[i] - 1;
                }
            }
        } else {
            solve(x, y + 1, remain, cost, map, visit);
        }

    }

    private static int[][] cover(int x, int y, int idx, int[][] map) {
        int[][] tmp = new int[size][size];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        for (int i = x; i <= x + arr[idx]; i++) {
            for (int j = y; j <= y + arr[idx]; j++) {
                tmp[i][j] = 0;
            }
        }
        return tmp;
    }

    private static boolean check(int x, int y, int idx, int[][] map) {
        for (int i = x; i <= x + arr[idx]; i++) {
            for (int j = y; j <= y + arr[idx]; j++) {
                if (i >= size || j >= size || map[i][j] == 0) return false;
            }
        }
        return true;
    }
}
