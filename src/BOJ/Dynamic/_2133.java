package BOJ.Dynamic;

import java.util.Scanner;

public class _2133 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];

        System.out.println(solve(n));
//        System.out.println(Arrays.toString(dp));
    }

    private static int solve(int num) {
        // 홀수인 경우, 타일을 채울수가 없다.
        if (num % 2 == 1) return 0;
        if (num <= 0) return 1;


        int ret = dp[num];
        if (ret != 0) return ret;

        ret += solve(num - 2) * 3;

        // n의 크기가 4이상부터 새로운 타입이 2가지 늘어난다.
        for (int i = 4; i <= num; i += 2) {
            ret += solve(num - i) * 2;
        }

        return dp[num] = ret;
    }
}
