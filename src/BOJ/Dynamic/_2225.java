package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _2225 {
    static int n, m, MOD = 1000000000;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(n, m));
    }

    // dp[num][cnt] : 합이 num 이고, 더 한 횟수가 cnt 일 떄의 개수
    private static long solve(int num, int cnt) {
        if (num == 0 && cnt == 0) return 1;
        if (num < 0 || cnt < 0) return 0;

        long ret = dp[num][cnt];
        if (ret != -1) return ret;

        ret = 0;
        for (int i = 0; i <= n; i++) {
            ret += solve(num - i, cnt - 1) % MOD;
        }
        return dp[num][cnt] = ret % MOD;
    }
}
