package BOJ.Dynamic;

import java.util.Scanner;

// 공통 부분 문자열
public class _5582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.nextLine().toCharArray();
        char[] b = sc.nextLine().toCharArray();
        int[][] dp = new int[a.length + 1][b.length + 1];

        int res = 0;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                char x = a[i - 1];
                char y = b[j - 1];
                if (x == y) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        System.out.println(res);
    }
}
