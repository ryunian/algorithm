package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _14606 {
    static int[] dp;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int res = solve(n);
        System.out.println(res);
        System.out.println(Arrays.toString(dp));
    }

    private static int solve(int num) {
        if (num == 1) return 0;

        int ret = dp[num];
        if(ret != -1) return ret;

        for (int i = 1; i < num ; i++) {
            ret = Math.max(ret, solve(num - i) + solve(i) + (num - i * i) );
        }

        return dp[num] = ret;
    }
}
