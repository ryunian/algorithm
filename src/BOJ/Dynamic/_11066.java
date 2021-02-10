package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11066 {
    static int n, INF = 987654321;
    static int[] arr, sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n + 1];
            sum = new int[n + 1];
            dp = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(dp[i], INF);
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }
            int res = solve(1, n);
            System.out.println(res);
        }
    }

    private static int solve(int left, int right) {
        if (left >= right) return 0;

        int ret = dp[left][right];
        if (ret != INF) return ret;
        if (left + 1 == right) return arr[left] + arr[right];

        for (int i = left; i < right; i++) {
            int tmp = solve(left, i) + solve(i + 1, right) + sum[right] - sum[left - 1];
            ret = Math.min(ret, tmp);
        }

        return dp[left][right] = ret;
    }
}
