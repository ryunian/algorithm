package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11060 {
    static int n, INF = 987654321;
    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(0);
        System.out.println(res == INF ? -1 : res);
    }

    private static int solve(int idx) {
        if (idx >= n) return INF;
        if (idx == n - 1) return 0;

        int ret = dp[idx];
        if (ret != INF) return ret;

        int max = arr[idx];
        for (int i = 1; i <= max; i++) {
            ret = Math.min(ret, solve(idx + i) + 1);
        }

        return dp[idx] = ret;
    }
}
