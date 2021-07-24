package BOJ.Mathematics;

import java.util.Scanner;

public class _5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buger = Integer.MAX_VALUE;
        int drink = Integer.MAX_VALUE;
        for(int i=0; i<3;i++){
            int x = sc.nextInt();
            if(buger>x) buger = x;
        }
        for(int i=0; i<2;i++){
            int x = sc.nextInt();
            if(drink>x) drink = x;
        }
        System.out.println(buger+drink-50);
    }
}
