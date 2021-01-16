package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 8.5 합친 LIS
public class JLIS {
    static int n, m;
    static int[] arrN, arrM;
    static int[][] dp;
    static long nINF = Long.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            arrN = new int[n];
            arrM = new int[m];
            for (int i = 0; i < n; i++) {
                arrN[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arrM[i] = sc.nextInt();
            }
            dp = new int[n + 1][m + 1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            int res = solve(-1, -1);
            System.out.println(res - 2);
        }
    }

    private static int solve(int idx1, int idx2) {
        int ret = dp[idx1 + 1][idx2 + 1];
        if (ret != -1) {
            return ret;
        }
        ret = 2;
        long a = idx1 == -1 ? nINF : arrN[idx1];
        long b = idx2 == -1 ? nINF : arrM[idx2];
        long maxValue = Math.max(a, b);

        for (int next = idx1 + 1; next < n; next++) {
            if (maxValue < arrN[next]) {
                ret = Math.max(ret, solve(next, idx2) + 1);
            }
        }

        for (int next = idx2 + 1; next < m; next++) {
            if (maxValue < arrM[next]) {
                ret = Math.max(ret, solve(idx1, next) + 1);
            }
        }

        return dp[idx1 + 1][idx2 + 1] = ret;
    }
}
/*
3
3 3
1 2 4
3 4 7
3 3
1 2 3
4 5 6
5 3
10 20 30 1 2
10 20 30
 */