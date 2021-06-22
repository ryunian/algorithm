package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int MOD = 1000000009;

        long[][] dp = new long[100000 + 1][3 + 1];
        dp[1][1] = dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        int start = 4;

        StringBuilder sb = new StringBuilder();
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = start; i <= n; i++) {
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
                dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
                dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
            }

            long sum = dp[n][1] + dp[n][2] + dp[n][3];
            sum %= MOD;
            sb.append(sum + "\n");

            start = Math.max(start, n);
        }
        System.out.print(sb.toString());
    }
}
