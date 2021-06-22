package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] arr = new long[n + 1][2];
        long[][] dp = new long[n + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + k) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0] + k, dp[i - 1][1]) + arr[i][1];
        }

        long res = Math.min(dp[n - 1][0], dp[n - 1][1]);
        System.out.println(res);
    }
}
