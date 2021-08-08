package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1210_2 {
    static int res;
    static int[][] arr;
    static List<Integer> pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int max = 100;

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            arr = new int[max][max + 2];
            pos = new ArrayList<>();

            for (int i = 0; i < max; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= max; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int start = -1;
            for (int i = 1; i <= max; i++) {
                if (arr[max - 1][i] == 1) {
                    pos.add(i);
                } else if (arr[max - 1][i] == 2) {
                    start = pos.size();
                    pos.add(i);
                }
            }

            res = 0;
            solve(max - 1, start, 0);
            System.out.println("#" + tc + " " + res);
        }
    }

    private static void solve(int row, int idx, int prev) {
        if (row == 0) {
            res = pos.get(idx) - 1;
            return;
        }
        int col = pos.get(idx);

        if (arr[row][col - 1] == 1 && prev == 0) {
            solve(row, idx - 1, -1);

        } else if (arr[row][col + 1] == 1 && prev == 0) {
            solve(row, idx + 1, 1);

        } else {
            solve(row - 1, idx, 0);
        }
    }
}
