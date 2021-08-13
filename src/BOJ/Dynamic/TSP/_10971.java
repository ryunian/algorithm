package BOJ.Dynamic.TSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 외판원 순회 2
public class _10971 {
    static int n, INF = 987654321;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = solve(0, 1);
        System.out.println(res);
    }

    private static int solve(int cur, int visit) {
        if (visit == (1 << n) - 1) {
            if(arr[cur][0] == 0){
                return INF;
            }
            return arr[cur][0];
        }

        int ret = dp[cur][visit];
        if(ret != 0) return ret;

        ret = INF;
        for (int i = 0; i < n; i++) {
            int next = 1 << i;
            if(arr[cur][i] == 0 || (visit & next) != 0) continue;

            ret = Math.min(ret, solve(i, visit | next) + arr[cur][i]);
        }

        return dp[cur][visit] = ret;
    }
}