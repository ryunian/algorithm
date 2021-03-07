package programmers.Lv3;

import java.util.Arrays;

public class 멀리뛰기 {
    private long[] dp;
    private int MOD = 1234567;

    public long solution(int n) {
        dp = new long[n + 2];
        Arrays.fill(dp, -1);
        long answer = solve(n + 1);
        return answer;
    }

    private long solve(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        dp[n] = solve(n - 2) % MOD + solve(n - 1) % MOD;

        return dp[n] % MOD;
    }
}

