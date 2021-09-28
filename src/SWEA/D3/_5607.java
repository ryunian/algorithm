package SWEA.D3;

import java.util.Scanner;

public class _5607 {
    static long MOD = 1234567891;

    public static void main(String[] args) {
        int max = 1000000;
        long[] arr = new long[max + 1];
        arr[1] = 1;
        for (int i = 2; i <= max; i++) {
            arr[i] = (arr[i - 1] * i) % MOD;
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long tmp = (arr[m] * arr[n - m]) % MOD;
            tmp = power(tmp, MOD - 2);
            long res = (arr[n] * tmp) % MOD;

            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static long power(long x, long y) {
        long res = 1;
        x %= MOD;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % MOD;
            y /= 2;
            x = (x * x) % MOD;
        }
        return res;
    }
}
