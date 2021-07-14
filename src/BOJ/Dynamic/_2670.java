package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2670 {
    private static double[] arr, dp;
    private static double res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        dp = new double[n];
        Arrays.fill(dp, -1);
        solve(n-1);
        System.out.println(String.format("%.3f", res));
    }

    private static double solve(int idx) {
        if(idx < 0 ) return 1;

        double ret = dp[idx];
        if(ret != -1) return ret;

        ret = Math.max(arr[idx], solve(idx-1) * arr[idx]);
        res = Math.max(ret, res);
        return dp[idx] = ret;
    }
}
