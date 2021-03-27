package programmers.Lv2;

import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        땅따먹기 test = new 땅따먹기();
        test.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
    }

    int[][] dp;

    public int solution(int[][] land) {
        int n = land.length;
        dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer,solve(n-1, i, land));
        }

        System.out.println(answer);

        return answer;
    }

    private int solve(int x, int y, int[][] land) {
        if (x < 0) return 0;

        int ret = dp[x][y];
        if (ret != -1) return ret;

        ret = 0;
        for (int i = 0; i < 4; i++) {
            if (i == y) continue;
            ret = Math.max(ret, solve(x - 1, i, land) + land[x][y]);
        }

        return dp[x][y] = ret;
    }
}
