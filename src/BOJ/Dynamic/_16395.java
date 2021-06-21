package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _16395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = solve(n, k);
        System.out.println(res);
    }

    private static int[][] dp;
    private static int solve(int n, int k) {
        if(k == 1 || n == k){
            return 1;
        }
        int ret = dp[n][k];
        if(ret != -1) return ret;

        ret = solve(n-1, k - 1) + solve(n-1, k);
        return dp[n][k] = ret;
    }
}
