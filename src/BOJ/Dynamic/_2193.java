package BOJ.Dynamic;

import java.util.Scanner;

public class _2193 {
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n + 1];

        System.out.println(solve(n));
    }

    private static long solve(int n) {
        if (n <= 2) return 1;

        long ret = dp[n];
        if (ret > 0) return ret;

        ret = solve(n - 2) + solve(n - 1);

        return dp[n] = ret;
    }
}
