package BOJ.Recursion;

import java.util.Scanner;

public class _2448 {
    static int n;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n + 1][n * 2];

        solve(1, n, n);
        print();
    }

    private static void solve(int x, int y, int height) {
        if (height % 2 == 0) {
            int div = height / 2;
            solve(x, y, div);
            solve(x + div, y - div, div);
            solve(x + div, y + div, div);
        }
        if (height == 3) {
            fill(x, y);
        }

    }

    private static void fill(int x, int y) {
        map[x][y] = 1;
        map[x + 1][y - 1] = 1;
        map[x + 1][y + 1] = 1;
        map[x + 2][y - 2] = 1;
        map[x + 2][y - 1] = 1;
        map[x + 2][y] = 1;
        map[x + 2][y + 1] = 1;
        map[x + 2][y + 2] = 1;
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

