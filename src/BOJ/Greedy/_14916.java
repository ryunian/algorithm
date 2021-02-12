package BOJ.Greedy;

import java.util.Scanner;

public class _14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = n / 5;
        int res = 0;
        while (i > 0) {
            if ((n - i * 5) % 2 == 0) {
                res = i + (n - i * 5)/2;
                break;
            }
            i--;
        }
        System.out.println(res == 0 ? -1 : res);
    }
}
