package SWEA.D2;

import java.util.Scanner;

public class _2001 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr = new int[x][x];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < x; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for (int i = 0; i <= x - y; i++) {
                for (int j = 0; j <= x - y; j++) {
                    max = Math.max(max, solve(i, j, y));
                }
            }
            System.out.printf("#%d %d\n", tc, max);
        }
    }

    private static int solve(int x, int y, int z) {
        int sum = 0;

        for (int i = x; i < x + z; i++) {
            for (int j = y; j < y + z; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
