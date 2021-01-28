package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _11727 {
    static int n, MOD = 10007;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n + 1];
        Arrays.fill(dp, -1);


        System.out.println(solve(n));
    }

    private static int solve(int idx) {
        if (idx <= 1) return 1;

        int ret = dp[idx];
        if (ret != -1) {
            return ret;
        }
        ret = (solve(idx - 2) * 2 + solve(idx - 1)) % MOD;
        return dp[idx] = ret;
    }
}
