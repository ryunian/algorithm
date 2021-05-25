package BOJ.Mathematics;

import java.util.Scanner;

public class _1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mod = 10000000000000000L;
        long val = 1;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            val *= i;
            while (true) {
                if (val % 100 == 0) {
                    val /= 100;
                    cnt += 2;
                } else {
                    break;
                }
            }
            val %= mod;
        }
        System.out.println(val % 10 == 0 ? cnt +1 : cnt);

    }
}
