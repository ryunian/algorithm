package BOJ.Dynamic;

import java.util.Scanner;

public class _1010 {
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            dp = new int[n + 1][m + 1];
            int res = solve(n, m);
            System.out.println(res);
        }
    }

    private static int solve(int x, int y) {
        if (x == 0 || x == y) return 1;
        if (dp[x][y] != 0) return dp[x][y];
        return dp[x][y] = solve(x - 1, y - 1) + solve(x, y - 1);
    }
}
