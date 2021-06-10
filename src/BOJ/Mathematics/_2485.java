package BOJ.Mathematics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Queue<Integer> queue = new LinkedList<>();
        int a = arr[1] - arr[0];
        queue.add(a);
        for (int i = 2; i < n; i++) {
            int b = arr[i] - arr[i-1];
            queue.add(b);
            a = gcd(a , b);
        }

        int sum = 0;
        while (!queue.isEmpty()){
            sum += queue.poll() / a -1;
        }
        System.out.println(sum);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b , a%b);
    }
}
