package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 8.12 비대칭 타일링
public class ASYMTILING {
    static int n, mod = 1000000007;
    static int[] dp = new int[101];
    static int[] cashe = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp, -1);
                Arrays.fill(cashe, -1);
            }
//            System.out.println(solve(n));
            System.out.println(solve2(n));
        }
    }

    private static int tiling(int width) {
        // 기저사례
        if (width <= 1) return 1;

        int ret = dp[width];
        if (ret != -1) return ret;

        ret = (tiling(width - 2) + tiling(width - 1)) % mod;
        return dp[width] = ret;
    }

    // 전체 타일수 - 대칭 타일 = 비대칭 타일
    private static int solve(int width) {
        if (width % 2 == 1) {
            return (tiling(width) - tiling(width / 2) + mod) % mod;
        }
        int ret = tiling(width);
        ret = (ret - tiling(width / 2) + mod) % mod;
        ret = (ret - tiling(width / 2 - 1) + mod) % mod;
        return ret;
    }

    // 직접 비대칭 타일링의 수 세는법
    private static int solve2(int width) {
        if (width <= 2) return 0;

        int ret = cashe[width];
        if (ret != -1) return ret;

        // 양 사이드가 대칭일 경우
        ret = solve2(width - 2) % mod;
        ret = (ret + solve2(width - 4)) % mod;

        // 양 사이드가 대칭이 아닐경우
        ret = (ret + tiling(width - 3)) % mod;
        ret = (ret + tiling(width - 3)) % mod;

        return cashe[width] = ret;
    }
}
/*
3
2
4
92
 */