package BOJ.Implementation;

import java.util.Scanner;

public class _1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int x = 1;
        int y = 10;

        for (int i = 1; i <= n; i++) {
            if (i / y > 0) {
                x++;
                y *= 10;
            }
            res += x;
        }
        System.out.println(res);
    }
}
