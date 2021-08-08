package SWEA.D1;

import java.util.Scanner;

public class _2029 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("#" + test_case + " " + x / y + " " + x % y);
        }
    }
}