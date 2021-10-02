package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 출근 경로
public class _5569_2 {
    static int MOD = 100000;
    static int n, m;
    static int[][][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        dp = new int[n][m][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j][0], -1);
                Arrays.fill(dp[i][j][1], -1);
            }
        }
        int res = solve(0, 0, 0, 0);
        System.out.println(res);
    }

    private static int solve(int x, int y, int prev, int cur) {
        if (x == n - 1 && y == m - 1) return 1;
        if (x >= n || y >= m) return 0;

        int ret = dp[x][y][prev][cur];
        if (ret != -1) return ret;
        ret = 0;
        // 이전방향이랑 현재방향이랑 같거나 x 나 y 가 0일 경우
        if (prev == cur || x == 0 || y == 0) {
            // 양방향
            ret += solve(x + 1, y, cur, 0) % MOD;
            ret += solve(x, y + 1, cur, 1) % MOD;
        } else {
            // 북쪽
            if (cur == 0) {
                ret += solve(x + 1, y, cur, 0) % MOD;
            }
            // 동쪽
            else {
                ret += solve(x, y + 1, cur, 1) % MOD;
            }
        }
        return dp[x][y][prev][cur] = ret % MOD;
    }
}
