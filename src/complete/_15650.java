package complete;

import java.util.Scanner;

public class _15650 {
    static boolean[] check;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
    static int x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        check = new boolean[x+1];
        temp = new int[y];
        backtracking(0,1);
        System.out.println(sb);
    }

    private static void backtracking(int z,int min) {
        if(y==z){
            for(int i=0; i<y; i++){
                sb.append(temp[i]+" ");
//                System.out.print(temp[i]+" ");
            }
            sb.append("\n");
//            System.out.println();
            return;
        }
        for(int i=min; i<=x; i++){
            if(!check[i]){
                check[i] = true;
                temp[z] = i;
                backtracking(z+1,i+1);
                check[i] = false;
            }
        }
    }
}
