package programmers;

import java.util.Arrays;

public class 가장큰정사각형찾기 {
    public static void main(String[] args) {
        가장큰정사각형찾기 test = new 가장큰정사각형찾기();
        test.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});
        test.solution(new int[][]{{0, 0, 1, 1,}, {1, 1, 1, 1}});
    }

    private int[][] dp, board;
    private int n, m;

    public int solution(int[][] board) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        dp = new int[n][m];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, solve(i, j));

            }
        }
        return res * res;
    }

    private int solve(int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (board[x][y] == 0) return 0;

        int ret = dp[x][y];
        if (ret != -1) return ret;
        ret = Math.min(solve(x - 1, y), solve(x, y - 1));
        ret = Math.min(ret, solve(x - 1, y - 1));
        return dp[x][y] = ret + 1;
    }
}
