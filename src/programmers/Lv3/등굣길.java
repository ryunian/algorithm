package programmers.Lv3;

import java.util.Arrays;

public class 등굣길 {
    public static void main(String[] args) {
        등굣길 test = new 등굣길();
        test.solution(4, 3, new int[][]{{2, 2}});
        test.solution(100, 100, new int[][]{});
        test.solution(100, 100, new int[][]{});
    }

    private int MOD = 1000000007;
    private int[][] map, dp;

    public int solution(int m, int n, int[][] puddles) {
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]][puddles[i][1]] = 1;
        }
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = solve(n, m);
        return answer;
    }

    private int solve(int n, int m) {
        if (n == 1 && m == 1) return 1;
        if (n < 1 || m < 1) return 0;
        if (map[n][m] == 1) return 0;

        int ret = dp[n][m];
        if (ret != -1) return ret;
        ret = 0;
        ret += solve(n - 1, m) + solve(n, m - 1);
        return dp[n][m] = ret % MOD;
    }
}
