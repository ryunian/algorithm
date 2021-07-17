package BOJ.Dynamic;

import java.util.Scanner;

public class _18249 {
    private static int MOD = (int) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int max = 191229 + 1;
        int[] dp = new int[max];

        for (int i = 1; i <= max; i++) {
            if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }


        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            sb.append(dp[n] + "\n");
        }
        System.out.print(sb.toString());
    }
}
