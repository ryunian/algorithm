package BOJ.Implementation;

import java.util.Scanner;

// 직사각형을 만드는 방법
public class _8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i * i; j <= n; j+= i) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
