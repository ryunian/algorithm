package SWEA.D3;

import java.util.Scanner;

// 부먹왕국의 차원 관문
public class _7964 {
    static int n, m, INF = 987654321;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n + 1];
            dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt() == 0 ? 1 : 0;
            }

            for (int i = 1; i <= n; i++) {
                dp[i] = INF;
                for (int j = 0; j <= m; j++) {
                    if (i - j < 0) break;
                    dp[i] = Math.min(dp[i], dp[i - j] + arr[i]);
                }
            }

            System.out.printf("#%d %d\n", tc, dp[n]);
        }
    }
}
