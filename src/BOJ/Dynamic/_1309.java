package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 동물원
public class _1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MOD = 9901;
        int[][] dp = new int[n + 1][3];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
    }
}
