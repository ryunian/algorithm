package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 성냥개비
public class _3687 {
    static int[] arr = {2, 3, 4, 5, 6, 7};
    static int[] matchstick = {1, 7, 4, 2, 0, 8};
    static long[] dp;
    static long INF = (long) Math.pow(10, 16);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        dp = new long[101];
        Arrays.fill(dp, INF);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            long a = findMinValue(n);
            String b = findMaxValue(n);
            sb.append(a + " " + b + "\n");
        }
        System.out.print(sb.toString());
    }

    private static long findMinValue(int n) {
        if (n < 0) return INF;
        if (n == 0) return 0;

        long ret = dp[n];
        if (ret != INF) return ret;

        for (int i = 0; i < 6; i++) {
            long tmp = (n == 6 && i == 4) ? 6 : matchstick[i];
            long val = findMinValue(n - arr[i]) * 10 + tmp;

            // n의 최대값은 100
            // 100일떄의 값은 15자리를 넘어가지 않는다.
            if (val > INF) continue;
            ret = Math.min(ret, val);
        }

        return dp[n] = ret;
    }

    private static String findMaxValue(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 != 0) {
            sb.append(7);
            n -= 3;
        }
        for (int i = 0; i < n / 2; i++) {
            sb.append(1);
        }
        return sb.toString();
    }
}
/*
2 1
3 7
4 4
5 5 3 2
6 9 6 0
7 8
 */
