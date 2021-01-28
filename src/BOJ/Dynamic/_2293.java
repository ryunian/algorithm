package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2293 {
    static int n, k;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[k + 1];

        solve();
    }

    private static void solve() {
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j - arr[i] >= 0) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
