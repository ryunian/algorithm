package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _22236 {
    private static int x, MOD;
    private static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        MOD = sc.nextInt();
        dp = new long[x + 1][x / 2 + 1];
        for (int i = 0; i <= x; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[2][0] = 1;
        System.out.println(solve(x, 0));
        System.out.println(Arrays.deepToString(dp));
    }

    private static long solve(int width, int height) {
        if (width == 0 && height == 0) return 1;
        if(0 < width && width < x && height == 0) return 0;
        if (height > x / 2 || height < 0 || width < 0) return 0;

        long ret = dp[width][height];
        if (ret != -1) return ret;

        long a = solve(width - 2, height - 2);
        long b = solve(width - 2, height + 2);
        long c = solve(width - 2, height);
        ret = a + b + c + c;

        return dp[width][height] = ret % MOD;
    }
}