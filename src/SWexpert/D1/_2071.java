package SWexpert.D1;

import java.util.Scanner;

public class _2071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=t; i++) {
            double sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += sc.nextInt();
            }
            double res = Math.round(sum / 10);


            sb.append("#"+i+" "+(int)res+"\n");
        }
        System.out.print(sb.toString());
    }
}