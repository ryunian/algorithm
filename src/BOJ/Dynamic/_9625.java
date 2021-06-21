package BOJ.Dynamic;

import java.util.Scanner;

public class _9625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[2][45 + 1];

        dp[0][0] = dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }
        System.out.println(dp[0][n] + " " + dp[1][n]);
    }
}
