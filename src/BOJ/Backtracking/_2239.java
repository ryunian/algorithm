package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2239 {
    static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            char[] x = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = x[j] - '0';
            }
        }
        backtracking(0);
    }

    private static void backtracking(int cnt) {
        if (cnt == 81) {
            print();
            System.exit(0);
            return;
        }
        int row = cnt / 9;
        int col = cnt % 9;
        if (sudoku[row][col] != 0) {
            backtracking(cnt + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
                if (check(row, col, k)) {
                    sudoku[row][col] = k;
                    backtracking(cnt + 1);
                    sudoku[row][col] = 0;
                }
            }
        }
    }


    private static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == val) {
                return false;
            }
            if (sudoku[i][y] == val) {
                return false;
            }
        }
        int row = x / 3 * 3;
        int col = y / 3 * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (sudoku[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void print() {
        for (int[] a : sudoku) {
            for (int b : a) {
                System.out.print(b + "");
            }
            System.out.println();
        }
    }
}
