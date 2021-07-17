package BOJ.Mathematics;

import java.util.Scanner;

public class _13270 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = n % 2 == 1 ? n / 2 + 1 : n / 2;
        int b = n % 3 == 2 ? (n / 3) * 2 + 1 : (n / 3) * 2;
        System.out.println(a + " " + b);
    }
}
