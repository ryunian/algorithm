package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1937 {
    static int n, res = 0;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, map[i][j]);
            }
        }
        System.out.println(res);

//        for (int[] a : dp) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }
    }

    private static int dfs(int x, int y, int cnt) {

        int ret = dp[x][y];
        if (ret != -1) {
            return ret;
        }

        ret = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (map[nx][ny] > cnt) {
                ret = Math.max(ret, dfs(nx, ny, map[nx][ny]) + 1);
            }
        }
        res = Math.max(ret, res);
        return dp[x][y] = ret;
    }

}
