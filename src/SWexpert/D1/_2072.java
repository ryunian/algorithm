package SWexpert.D1;

import java.util.Scanner;

public class _2072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int x = sc.nextInt();
                if(x % 2 == 1) sum += x;
            }

            sb.append("#"+(i+1)+" "+sum+"\n");
        }
        System.out.print(sb.toString());
    }
}
