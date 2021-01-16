package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 8.7 원주율 외우기
public class PI {
    static int INF = 987654321;
    static String str;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            str = sc.next();
            dp = new int[10002];
            Arrays.fill(dp, -1);
            System.out.println(solve(0));
        }
    }

    private static int solve(int begin) {
        if (begin == str.length()) return 0;

        int ret = dp[begin];
        if (ret != -1) return ret;

        ret = INF;
        for (int i = 3; i <= 5; i++) {
            if (begin + i <= str.length()) {
                ret = Math.min(ret, solve(begin + i) + level(begin, begin + i - 1));
            }
        }
        return dp[begin] = ret;
    }

    private static int level(int a, int b) {
        char[] c = str.substring(a, b+1).toCharArray();

        // level 1 : 한글자로 이루어진 문자열인지 체크
        boolean lv1 = true;
        for (int i = 0; i < c.length; i++) {
            if (c[0] != c[i]) lv1 = false;
        }
        if (lv1) return 1;

        // level 2 & 5 : 등차수열인지 체크
        boolean lv5 = true;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[1] - c[0] != c[i + 1] - c[i]) lv5 = false;
        }
        if (lv5 && Math.abs(c[1] - c[0]) == 1) return 2;

        // level 4 : 두수가 번갈아 등장하는지 체크
        boolean lv4 = true;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != c[i % 2]) lv4 = false;
        }

        if (lv4) return 4;
        if (lv5) return 5;
        return 10;
    }
}
/*
5
12341234
11111222
12122222
22222222
12673939
 */