package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _19947 {
    static int H, Y;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt(); // 초기비용
        Y = sc.nextInt(); // 투자기간

        dp = new int[Y + 1];
        Arrays.fill(dp, H);
        int res = solve(Y);
        System.out.println(res);
    }

    private static int solve(int year) {
        if (year < 0) return 0;
        if (year == 0) return H;

        int ret = dp[year];
        if (ret != H) {
            return ret;
        }
        ret = (int) Math.max(ret, solve(year - 1) * 1.05);
        ret = (int) Math.max(ret, solve(year - 3) * 1.2);
        ret = (int) Math.max(ret, solve(year - 5) * 1.35);

        return dp[year] = ret;
    }
}
