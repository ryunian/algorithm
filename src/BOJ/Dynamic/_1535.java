package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1535 {
    static int n, INF = -987654321;
    static int[] cost, happy;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1];
        happy = new int[n + 1];
        dp = new int[n + 1][101];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(solve(n, 100));

    }

    private static int solve(int idx, int hp) {
        if (idx < 0) {
            return 0;
        }
        int ret = dp[idx][hp];
        if (ret != -1) {
            return ret;
        }
        if(hp - cost[idx] > 0){
            ret = solve(idx - 1, hp - cost[idx]) + happy[idx];
        }
        ret = Math.max(ret, solve(idx - 1, hp));

        return dp[idx][hp] = ret;
    }
}
