package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 인증된 쉬운 게임
public class _22846 {
    static int x;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        dp = new int[x + 1][2];
        for (int i = 0; i <= x; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = solve(1, 0);
        System.out.println(res == 0 ? "Kali" : "Ringo");

    }

    static int solve(int n, int sel) {
        if (n == x) return (sel + 1) % 2;

        int ret = dp[n][sel];
        if (ret != -1) return ret;

        ret = (sel + 1) % 2;

        int div;
        // 약수 구하기 O(sqrt(n))
        for (int i = 1; i * i <= n; i++) {
            if (n % i != 0) continue;
            div = i + n;
            if (div <= x && sel == solve(div, ret)) {
                return dp[n][sel] = sel;
            }
            div = n / i + n;
            if (div <= x && sel == solve(div, ret)) {
                return dp[n][sel] = sel;
            }
        }

        return dp[n][sel] = ret;
    }
}