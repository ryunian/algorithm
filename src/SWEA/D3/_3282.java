package SWEA.D3;

import java.util.Scanner;

// 0/1 Knapsack
public class _3282 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] weight = new int[n + 1];
            int[] score = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                weight[i] = sc.nextInt();
                score[i] = sc.nextInt();
            }

            int[][] dp = new int[k + 1][n + 1];
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    int tmp = dp[i][j - 1];
                    if (i >= weight[j]) {
                        int x = dp[i - weight[j]][j - 1] + score[j];
                        dp[i][j] = Math.max(x, tmp);
                    } else {
                        dp[i][j] = tmp;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, dp[k][n]);
        }
    }
}
