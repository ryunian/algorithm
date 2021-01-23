package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1912 {
    static int n, nINF = -987654321, res = Integer.MIN_VALUE;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        Arrays.fill(dp, nINF);

        solve(n - 1);
//        System.out.println(Arrays.toString(dp));
        System.out.println(res);
    }

    private static int solve(int idx) {
        // 기저사례
        if (idx == -1) return nINF;

        // 메모이제이션
        int ret = dp[idx];
        if (ret != nINF) return ret;

        ret = Math.max(arr[idx], solve(idx-1) + arr[idx]);

        // 최대값
        res = Math.max(res, ret);

        return dp[idx] = ret;
    }
}
