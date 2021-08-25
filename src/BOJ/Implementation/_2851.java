package BOJ.Implementation;

import java.util.Scanner;

// 슈퍼 마리오
public class _2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int diff = 100;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            int abs = Math.abs(100 - sum);
            if (diff >= abs) {
                res = sum;
                diff = abs;
            }
            if(sum > 100) break;
        }
        System.out.println(res);
    }
}
