package BOJ.Backtracking;

import java.util.Scanner;

public class _10974 {
    static boolean[] check;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        check = new boolean[n];

        solve(0, n);
        System.out.print(sb.toString());
    }

    private static void solve(int x, int y) {
        if(x == y){
            for (int i = 0; i < y; i++) {
                sb.append(arr[i]+1+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < y; i++) {
            if(!check[i]){
                check[i] = true;
                arr[x] = i;
                solve(x+1, y);
                check[i] = false;
            }
        }
    }
}
