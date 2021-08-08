package SWEA.D1;

import java.util.Scanner;

public class _2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            int res = str.charAt(i) - 'A' + 1;
            System.out.print(res + " ");
        }
    }
}
