package BOJ.Implementation;

import java.util.Scanner;

// 달팽이
public class _1913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = n * n;
        int[][] arr = new int[n][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = -1, y = 0, k = 0;
        int cnt = 1;
        int row = 0, col = 0;
        while (n > 0) {
            while (cnt++ < 2) {
                for (int j = 0; j < n; j++) {
                    x += dx[k];
                    y += dy[k];
                    if (num == m) {
                        row = x + 1;
                        col = y + 1;
                    }
                    arr[x][y] = num--;
                }
                k = (k + 1) % 4;
            }
            cnt = 0;
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for (int[] a : arr) {
            for (int b : a) {
                sb.append(b + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.print(row + " " + col);
    }
}
