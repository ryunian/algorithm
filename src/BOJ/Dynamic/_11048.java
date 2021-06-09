package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11048 {
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(n-1, m-1));

    }

    private static int solve(int x, int y) {
        if(x < 0 || y < 0) return 0;

        int ret = dp[x][y];
        if(ret != -1){
            return ret;
        }

        ret = Math.max(solve(x-1,y-1), Math.max(solve(x-1, y), solve(x , y-1))) + map[x][y];
        return dp[x][y] = ret;
    }
}
