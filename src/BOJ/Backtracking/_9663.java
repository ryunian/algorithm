package BOJ.Backtracking;

import java.util.Scanner;

public class _9663 {
    static int[] check;
    static int x;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        check = new int[x+1];
        NQueen(0);
        System.out.println(result);
    }

    private static void NQueen(int row) {
        if(row==x){
            result++;
            return;
        }
        for(int i=0; i<x;i++){
            check[row] = i;
            if(checking(row)){
                NQueen(row+1);
            }
        }
    }
    private static boolean checking(int x){
        for(int i=0; i<x;i++){
            // 가로 세로
            if(check[i] == check[x]){
                return false;
            }
            // 대각선
            if(Math.abs(check[x]-check[i]) == (x-i)){
                return false;
            }

        }
        return true;
    }
}
