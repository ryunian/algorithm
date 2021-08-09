package programmers.Lv3;

import java.util.Arrays;

public class 거스름돈 {
    public static void main(String[] args) {
        거스름돈 test = new 거스름돈();
        test.solution(5, new int[]{1, 2, 5});
    }


    public int solution(int n, int[] money) {
        int MOD = 1000000007;
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = (i % money[0] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j - money[i]];
                dp[j] %= MOD;
            }
        }
        return dp[n];
    }

    // 시간초과
    public int Fail(int n, int[] money) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][money.length];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < money.length; j++) {
                int tmp = 0;
                if (i == money[j]) tmp++;
                if (j != 0) tmp = (tmp + dp[i][j - 1]) % MOD;
                if (i - money[j] >= 1) tmp = (tmp + dp[i - money[j]][j]) % MOD;
                dp[i][j] = tmp;
            }
        }

        return dp[n - 1][money.length - 1];
    }
}