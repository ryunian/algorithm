package BOJ.Backtracking;

import java.util.Scanner;

public class _15651 {
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        temp = new int[y];
        backtracking(x,y,0);
        System.out.println(sb);
    }

    private static void backtracking(int x, int y, int z) {
        if(y==z){
            for(int i=0;i<z;i++){
                sb.append(temp[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=x;i++){
            temp[z] = i;
            backtracking(x,y,z+1);
        }
    }
}
