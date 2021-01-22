package BOJ.etc;

import java.util.Scanner;

public class _2523 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=0; i<x;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        int y = x-1;
        for(int i=x; i<x*2+1; i++){
            for(int j=0; j<y;j++){
                System.out.print("*");
            }
            System.out.println();
            y--;
        }
    }
}
