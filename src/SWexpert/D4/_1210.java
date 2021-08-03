package SWexpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1210 {
    static int res;
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 100;

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            arr = new int[max][max + 2];
            visit = new boolean[max][max + 2];

            int start = -1;
            for (int i = 0; i < max; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= max; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 2) start = j;
                }
            }

            res = 0;
            solve(max - 1, start);
            System.out.println("#" + tc + " " + res);
        }
    }

    private static void solve(int row, int col) {
        if (row == 0) {
            res = col - 1;
            return;
        }
        visit[row][col] = true;

        if (arr[row][col - 1] == 1 && !visit[row][col - 1]) {
            solve(row, col - 1);

        } else if (arr[row][col + 1] == 1 && !visit[row][col + 1]) {
            solve(row, col + 1);

        } else {
            solve(row - 1, col);
        }
    }
}
