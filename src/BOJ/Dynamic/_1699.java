package BOJ.Dynamic;

import java.util.Scanner;

public class _1699 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];
        System.out.println(solve(n));
    }

    // dp[num] : 숫자가 num일떄 제곱수의 항의 개수
    private static int solve(int num) {
        // 기저사례
        if (num == 0) return 0;

        // 메모이제이션
        int ret = dp[num];
        if (ret > 0) return ret;

        // 최대값 제곱수가 1로만 이루어져있을때
        ret = num;
        for (int i = 1; i * i <= num; i++) {
            ret = Math.min(ret, solve(num - i * i) + 1);

        }
        return dp[num] = ret;
    }
}
