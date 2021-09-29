package SWEA.D4;

import java.util.Scanner;

// 원점으로 집합
public class _8458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();

            int max = 0;
            long chk = -1;
            boolean isok = true;
            for (int i = 0; i < n; i++) {
                int a = Math.abs(sc.nextInt());
                int b = Math.abs(sc.nextInt());
                int x = a + b;
                max = Math.max(max, x);
                if (chk == -1) {
                    chk = x % 2;
                } else if (chk != x % 2) {
                    isok = false;
                }
            }

            if (!isok) {
                System.out.printf("#%d %d\n", tc, -1);
            } else {
                int sum = 0;
                int num = 0;
                while (true) {
                    if (sum >= max && (sum - max) % 2 == 0) {
                        break;
                    }
                    sum += ++num;
                }
                System.out.printf("#%d %d\n", tc, num);
            }
        }
    }
}