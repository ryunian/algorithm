package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[][][] dp = new int[n + 1][w + 1][2];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        int res = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + (arr[i] == 1 ? 1 : 0);
            for (int j = 1; j <= w; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][0]) + (arr[i] == 1 ? 1 : 0);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j][1]) + (arr[i] == 2 ? 1 : 0);
                res = Math.max(res, dp[i][j][0]);
                res = Math.max(res, dp[i][j][1]);
            }
        }
        System.out.println(res);
    }
}
