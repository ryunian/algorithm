package programmers;

import java.util.Arrays;

public class 정수삼각형 {
    public static void main(String[] args) {
        정수삼각형 test = new 정수삼각형();
        test.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});

    }

    private int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, triangle);
    }

    private int solve(int x, int y, int[][] arr) {
        if (x == arr.length - 1) return arr[x][y];

        int ret = dp[x][y];
        if (ret != -1) return ret;

        ret = Math.max(solve(x + 1, y, arr), solve(x + 1, y + 1, arr)) + arr[x][y];

        return dp[x][y] = ret;
    }
}
