package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2749 {
    public static void main(String[] args) throws IOException {
        // 피보나치 수를 나눌 수를 K라고 할 때, k = 10^n 이면, 피사노 주기는 15 * 10^(n-1) 이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int MOD = 1000000;
        int pisano = 15 * MOD;
        int[] dp = new int[pisano + 1];

        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i < pisano && i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] ) % MOD;
        }
        if (n >= pisano) {
            n %= pisano;
        }
        System.out.println(dp[(int) n]);
    }
}
