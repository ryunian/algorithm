package BOJ.Backtracking;

import java.util.Scanner;

public class _2580 {
    static int[][] sudoku = new int[9][9];
    static int[] bin;
    static StringBuilder sb = new StringBuilder();
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int q = sc.nextInt();
                if (q == 0) k++;
                sudoku[i][j] = q;
            }
        }
        dfs(0);
//        for (int[] i : sudoku) {
//            for (int j : i) {
//                sb.append(j + " ");
//            }
//            sb.append("\n");
//        }
//        System.out.println("result : ");
//        System.out.println(sb.toString());
    }
    private static void show(int[][] x){
        for (int[] i : sudoku) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void dfs(int x) {
        if (x == 81) {
            show(sudoku);
            System.exit(0);
            return;
        }
        int row = x / 9;
        int column = x % 9;
        if(sudoku[row][column] !=0){
            dfs(x+1);
        }else {
            for (int value = 1; value <= 9; value++) {
                if (check(row, column, value)) {
//                    System.out.println(row+" "+column+" "+value);
                    sudoku[row][column] = value;
                    dfs(x + 1);
                    sudoku[row][column] = 0;
                }
            }
        }
    }

    private static boolean check(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] == value) {
                return false;
            }
        }
        int row2 = row / 3 * 3;
        int column2 = column / 3 * 3;
        for (int i = row2; i < row2 + 3; i++) {
            for (int j = column2; j < column2 + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
