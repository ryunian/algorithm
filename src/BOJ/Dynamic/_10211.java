package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10211 {
    private static int n, INF = -987654321;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (test-- > 0) {
            res = INF;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            arr = new int[n];
            dp = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = INF;
            }

            solve(n - 1);
            sb.append(res + "\n");
        }
        System.out.print(sb.toString());

    }

    private static int res;

    private static int solve(int idx) {
        if (idx < 0) return 0;
        int ret = dp[idx];
        if (ret != INF) return ret;


        ret = Math.max(arr[idx], solve(idx - 1) + arr[idx]);
        res = Math.max(res, ret);

        return dp[idx] = ret;
    }
}
