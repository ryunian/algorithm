package BOJ.Dynamic;

import java.util.Scanner;

public class _11051 {
    static int n, k, MOD = 10007;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        dp = new int[n + 1][k + 1];

        System.out.println(solve(n, k));
    }

    // 5C2 = 4C1 + 4C2
    private static int solve(int x, int y) {
        if (x == 0 || x == y) return 1;
        int ret = dp[x][y];
        if (ret != 0) return ret;

        ret = solve(x - 1, y - 1) + solve(x, y - 1);

        return dp[x][y] = ret % MOD;
    }
}
