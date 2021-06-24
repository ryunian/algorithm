package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _13699 {
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n + 1];
        Arrays.fill(dp, -1);
        long res = solve(n);
        System.out.println(res);
    }

    private static long solve(int num) {
        if (num == 0) return 1;
        long ret = dp[num];
        if (ret != -1) return ret;

        ret = 0;
        for (int i = 0; i < num; i++) {
            ret += solve(i) * solve(num - i - 1);
        }

        return dp[num] = ret;
    }
}
