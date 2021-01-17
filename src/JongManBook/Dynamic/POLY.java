package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 8.14 폴리오미노
public class POLY {
    static int MOD = 10000000;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            dp = new int[n + 1][n + 1];
            for (int j = 0; j < dp.length; j++) {
                Arrays.fill(dp[j], -1);
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                // i : 첫째줄의 정사각형의 개수
                sum += solve(n, i);
                sum %= MOD;
            }
            System.out.println(sum);
        }
    }

    // n : 총 정사각형 갯수
    // first : 맨 위 정사각형 갯수
    private static int solve(int n, int first) {
        // 더 이상 아래에 정사각형이 없음
        if (n == first) return 1;

        int ret = dp[n][first];
        if (ret != -1) return ret;
        ret = 0;

        for (int next = 1; next <= n - first; next++) {
            // 현재 정사각형과 바로 아래의 정사각형의 경우의 수
            int add = next + first - 1;
            // 그 다음의 정사각형의 경우의 수
            add *= solve(n - first, next);
            ret += add;
            ret %= MOD;
        }
        return dp[n][first] = ret;
    }
}
/*
3
2
4
92
 */