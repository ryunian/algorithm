package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5557 {
    static int n;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new long[n+1][100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(n-1, arr[n]));
    }

    private static long solve(int idx, int ans) {
        if(idx == 1 && ans == arr[1]){
            return dp[idx][ans] = 1;
        }
        if(idx == 1 && ans != arr[1]){
            return dp[idx][ans] = 0;
        }
        long ret = dp[idx][ans];
        if (ret != -1) return ret;

        ret = 0;
        if (ans - arr[idx] >= 0) {
            ret += solve(idx - 1, ans - arr[idx]);
        }
        if (ans + arr[idx] <= 20) {
            ret += solve(idx - 1, ans + arr[idx]);
        }

        return dp[idx][ans] = ret;
    }

}
