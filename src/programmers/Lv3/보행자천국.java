package programmers.Lv3;

import java.util.Arrays;

public class 보행자천국 {
    public static void main(String[] args) {
        보행자천국 test = new 보행자천국();
        test.solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 2}, {0, 2, 0}});
        test.solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}});
    }

    int MOD = 20170805;
    int[][] map, dp;

    public int solution(int m, int n, int[][] cityMap) {
        map = cityMap;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int answer = solve(m - 1, n - 1, 0);
        return answer;
    }

    private int solve(int x, int y, int direction) {
        if (x == 0 && y == 0) return 1;
        if (x < 0 || y < 0 || map[x][y] == 1) return 0;
        if (map[x][y] == 2 && direction != 0) {
            if (direction == 1) {
                return solve(x - 1, y, 1);
            } else if (direction == 2) {
                return solve(x, y - 1, 2);
            }
        }

        int ret = dp[x][y];
        if (ret != -1) return ret;
        ret = 0;
        ret += solve(x - 1, y, 1) + solve(x, y - 1, 2);

        return dp[x][y] = ret % MOD;
    }
}
