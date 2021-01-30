package BOJ.Dynamic;

import java.util.Scanner;

public class _2011 {
    static int MOD = 1000000;
    static int[] dp, arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        dp = new int[str.length()];

        solve();
    }

    private static void solve() {
        dp[0] = arr[0] == 0 ? 0 : 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                dp[i] += dp[i - 1] % MOD;
            }
            int tmp = arr[i - 1] * 10 + arr[i];
            if (10 <= tmp && tmp <= 26) {
                if (i - 2 < 0) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2] % MOD;
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[arr.length - 1] % MOD);
    }
}
