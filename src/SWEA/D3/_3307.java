package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3307 {
    private static int n;
    private static long res;
    private static long[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new long[n];
            dp = new long[n];
            res = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
                dp[j] = 1;
            }

            solve(n - 1);
            sb.append("#").append(i).append(" ").append(res).append("\n");
        }
        System.out.print(sb.toString());
    }

    // n이 작으니 n^2 풀이로 무리없음
    private static long solve(int idx) {
        if (idx < 0) return 0;
        long ret = dp[idx];
        if (ret != 1) return ret;

        for (int i = 0; i < idx; i++) {
            if (arr[i] < arr[idx]) {
                ret = Math.max(ret, solve(i) + 1);
            } else {
                res = Math.max(res, solve(i));
            }
        }
        res = Math.max(res, ret);
        return dp[idx] = ret;
    }
}
