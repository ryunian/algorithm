package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1890 {
    static int n;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(n-1, n-1));
    }

    private static long solve(int x, int y) {
        if(x == 0 && y == 0) return 1;

        long ret = dp[x][y];
        if(ret != -1) return ret;

        ret = 0;
        for (int i = 1; i < n; i++) {
            if(x-i >= 0 && i == map[x-i][y]){
                ret += solve(x-i, y);
            }
        }
        for (int i = 1; i < n; i++) {
            if(y-i >= 0 && i == map[x][y-i]){
                ret += solve(x, y-i);
            }
        }

        return dp[x][y] = ret;
    }
}
