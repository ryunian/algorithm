package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12852 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int a = dp[i / 3];
            int b = dp[i / 2];
            int c = dp[i - 1];
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(Math.min(a, b), c) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(a, c) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(b, c) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        sb.append(dp[n]).append("\n").append(n).append(" ");

        while (n > 1) {
            if (n % 3 == 0 && dp[n / 3] == dp[n] - 1) {
                n /= 3;
            } else if (n % 2 == 0 && dp[n / 2] == dp[n] - 1) {
                n /= 2;
            } else {
                n -= 1;
            }
            sb.append(n + " ");
        }
        System.out.println(sb.toString());
    }
}
