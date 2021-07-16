package BOJ.Mathematics;

import java.util.Scanner;

public class _13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();

        long res = 0;
        for (int i = 0; i < n; i++) {
            res++;
            arr[i] -= x;
            if(arr[i] < 0) continue;
            res += arr[i] / y;
            res += arr[i] % y == 0 ? 0 : 1;
        }
        System.out.println(res);
    }
}
