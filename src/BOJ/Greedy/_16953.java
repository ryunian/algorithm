package BOJ.Greedy;

import java.util.Scanner;

public class _16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 1;
        while (y > x) {
            if (y % 10 == 1) {
                y /= 10;
            } else if (y % 2 == 0) {
                y /= 2;
            } else {
                break;
            }
            cnt++;
        }
        if (y == x) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
