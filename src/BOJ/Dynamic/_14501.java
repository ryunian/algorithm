package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501 {
    static int n, NINF = -987654321;
    static int[] time, pay;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n];
        pay = new int[n];
        dp = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }
        System.out.println(solve(0));
    }

    private static int solve(int day) {
        if (day == n) return 0;
        if (day > n) return NINF;

        int ret = dp[day];
        if (ret != -1) return ret;
        ret = Math.max(solve(day + 1), solve(day + time[day]) + pay[day]);

        return dp[day] = ret;
    }
}
