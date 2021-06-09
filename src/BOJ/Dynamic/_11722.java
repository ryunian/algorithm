package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11722 {
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        Arrays.fill(dp, -1);

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(solve(i), res);
        }
        System.out.println(res);
    }

    private static int solve(int idx) {
        if (idx < 0) {
            return 0;
        }
        int ret = dp[idx];
        if (ret != -1) {
            return ret;
        }
        ret = 1;
        for (int i = idx - 1; i >= 0; i--) {
            if (arr[idx] < arr[i]) {
                ret = Math.max(solve(i) + 1, ret);
            }
        }
        return dp[idx] = ret;
    }
}
