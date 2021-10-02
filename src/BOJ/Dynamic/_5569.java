package BOJ.Dynamic;

import java.util.Scanner;

// 출근 경로
public class _5569 {
    public static void main(String[] args) {
        int MOD = 100000;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        // row , col , 방향 , 회전가능여부
        int[][][][] dp = new int[n][m][2][2];

        for (int i = 1; i < n; i++) dp[i][0][0][0] = 1;
        for (int i = 1; i < m; i++) dp[0][i][1][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i - 1][j][1][0];
                dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % MOD;
                dp[i][j][1][1] = dp[i][j - 1][0][0];
            }
        }
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res = (res + dp[n - 1][m - 1][i][j]) % MOD;
            }
        }
        System.out.println(res);
    }
}
