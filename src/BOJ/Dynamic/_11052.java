package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11052 {
    static int n;
    static int[] card, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        card = new int[n + 1];
        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);

        System.out.println(solve(n));
    }

    private static int solve(int num) {
        // 기저사례
        if (num == 0) return 0;

        int ret = dp[num];
        if (ret != -1) return ret;

        ret = 0;
        for (int i = 1; i <= num; i++) {
            ret = Math.max(ret, solve(num - i) + card[i]);
        }

        return dp[num] = ret;
    }
}
