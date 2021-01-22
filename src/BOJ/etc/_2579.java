package BOJ.etc;

import java.util.Scanner;

public class _2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        function(n, arr, dp);
        System.out.println(dp[n - 1]);
    }

    private static void function(int n, int[] arr, int[] dp) {
        if (n == 0) return;
        dp[0] = arr[0];

        if (n == 1) return;
        dp[1] = arr[0] + arr[1];

        if (n == 2) return;
        dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(arr[i] + arr[i - 1] + dp[i - 3], arr[i] + dp[i - 2]);
        }
    }
}
