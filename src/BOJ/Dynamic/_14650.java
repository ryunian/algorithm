package BOJ.Dynamic;

import java.util.Scanner;

public class _14650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dp = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            if (i == 2) dp[i] = 2;
            else {
                dp[i] = dp[i - 1] * 3;
            }
        }
        System.out.println(dp[x]);
    }
}
