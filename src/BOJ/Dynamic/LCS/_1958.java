package BOJ.Dynamic.LCS;

import java.util.Scanner;

// LCS 3
public class _1958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        int a = str1.length();
        int b = str2.length();
        int c = str3.length();
        int[][][] dp = new int[a + 1][b + 1][c + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    char x = str1.charAt(i - 1);
                    char y = str2.charAt(j - 1);
                    char z = str3.charAt(k - 1);
                    if (x == y && y == z) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i][j - 1][k], dp[i][j][k - 1]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    }
                }
            }
        }
        System.out.println(dp[a][b][c]);
    }
}