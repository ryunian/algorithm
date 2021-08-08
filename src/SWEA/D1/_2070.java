package SWEA.D1;

import java.util.Scanner;

public class _2070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            char res;

            if(a < b){
                res = '<';
            }else if(a > b){
                res = '>';
            }else{
                res = '=';
            }

            sb.append("#"+i+" "+res+"\n");
        }
        System.out.print(sb.toString());
    }
}
