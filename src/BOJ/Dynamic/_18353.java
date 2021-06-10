package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _18353 {
    static int max = 0;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        Arrays.fill(dp, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            solve(i);
        }
        System.out.println(n - max);
    }

    private static int solve(int idx) {
        int ret = dp[idx];
        if(ret != -1) return ret;

        ret = 1;
        for (int i = idx-1; i >= 0; i--) {
            if(arr[idx] < arr[i]){
                ret = Math.max(ret, solve(i) +1);
            }
        }
        max = Math.max(ret, max);
        return dp[idx] = ret;
    }
}
