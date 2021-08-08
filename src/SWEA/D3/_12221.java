package SWEA.D3;

import java.util.Scanner;

public class _12221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int div = 10;
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int res = 0;
            if (a / div > 0 || b / div > 0) {
                res = -1;
            } else {
                res = a * b;
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
