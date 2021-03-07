package programmers.Lv3;

import java.util.Arrays;

public class _2xn타일링 {
    public static void main(String[] args) {
        _2xn타일링 test = new _2xn타일링();
        test.solution(4);
//        test.solution(10000);
//        test.solution(60000);
    }

    static int[] dp;
    static int MOD = 1000000007;

    public int solution(int n) {
        dp = new int[n + 1];
        System.out.println(sol(n));

        return sol(n);
    }

    // n의 값이 너무 커서 스택오버플로우
    private int solve(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        int ret = dp[n];
        if (ret != -1) return ret;
        ret = (solve(n - 2) + solve(n - 1)) % MOD;

        return dp[n] = ret % MOD;
    }

    private int sol(int n){
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%MOD;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n] % MOD;
    }
}
