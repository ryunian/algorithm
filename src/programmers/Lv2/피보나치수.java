package programmers.Lv2;

import java.util.Arrays;

public class 피보나치수 {
    int[] dp;
    int MOD = 1234567;

    public int solution(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int answer = fibonach(n);

        return answer;
    }

    public int fibonach(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int ret = dp[n];
        if (ret != -1) return ret;

        ret = fibonach(n - 1) + fibonach(n - 2);

        return dp[n] = ret % MOD;
    }
}
