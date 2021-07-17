package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _22114 {
    private static int n, k;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, solve(i, 0));
        }
        System.out.println(res);

    }

    private static int solve(int idx, int jump) {
        if (idx ==  0) return 1;

        int ret = dp[idx][jump];
        if (ret != -1) return ret;

        ret = 1;
        if(arr[idx] <= k){
            ret = Math.max(ret, solve(idx-1, jump)+1);
        }else {
            if(jump == 0){
                ret = Math.max(ret, solve(idx-1, 1)+1);
            }
        }
        return  dp[idx][jump] = ret;
    }
}
