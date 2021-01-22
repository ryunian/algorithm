package BOJ.Backtracking;

import java.util.Scanner;

public class _15652 {
    static int x,y;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        temp = new int[y];
        backtracking(0,1);
        System.out.println(sb);
    }

    private static void backtracking(int count, int min) {
        if(y==count){
            for(int i=0; i<count;i++){
                sb.append(temp[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=min; i<=x; i++,min++){
            temp[count] = i;
            backtracking(count+1,i);

        }
    }
}
