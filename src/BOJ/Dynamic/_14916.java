package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 거스름돈
public class _14916 {
    static int n, INF = 987654321;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, INF);
        int res = solve(n);
        System.out.println(res >= INF ? -1 : res);
    }

    private static int solve(int n) {
        if (n < 0) return INF;
        if (n == 0) return 0;

        int ret = dp[n];
        if (ret != INF) return ret;
        ret = Math.min(solve(n - 2), solve(n - 5)) + 1;
        return dp[n] = ret;
    }
}
