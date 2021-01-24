package BOJ.Dynamic;

import java.util.Scanner;

public class _11057 {
    static int n, MOD = 10007;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new long[n + 1][10];

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += solve(n, i);
        }
        System.out.println(sum % MOD);
    }

    private static long solve(int place, int digit) {
        // 기저사례
        if (place == 1) return 1;

        // 메모이제이션
        if (dp[place][digit] > 0) {
            return dp[place][digit];
        }

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= i; j++) {
                // place 자리의 i 값은 그 아래 자리의 자신보다 같거나 큰 값의 수이다.
                dp[place][i] += solve(place - 1, j);
                dp[place][i] %= MOD;
            }
        }

        return dp[place][digit];
    }
}
