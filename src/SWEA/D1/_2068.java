package SWEA.D1;

import java.util.Scanner;

public class _2068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            int res = 0;
            for (int j = 0; j < 10; j++) {
                res = Math.max(res, sc.nextInt());
            }
            sb.append("#" + i + " " + res + "\n");
        }
        System.out.print(sb.toString());
    }
}
