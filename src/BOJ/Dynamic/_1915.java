package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1915 {
    static int n, m, res = 0;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solve(i, j);
            }
        }

        System.out.println(res);
    }

    private static int solve(int x, int y) {
        if (x < 0 || y < 0 || map[x][y] == 0) return 0;

        int ret = dp[x][y];
        if (ret != -1) return ret;

        int a = (int) Math.sqrt(solve(x - 1, y));
        int b = (int) Math.sqrt(solve(x, y-1));
        int c = (int) Math.sqrt(solve(x - 1, y-1));

        ret = Math.min(Math.min(a,b),c)+1;

        ret *= ret;

        res = Math.max(ret, res);
        return dp[x][y] = ret;
    }
}
