package BOJ.Greedy;

import java.util.Scanner;

// 수들의 합
public class _1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long num = 0;
        while (n >= sum) {
            sum += (++num);
        }
        System.out.println(n == sum ? num  : num-1);
    }
}
