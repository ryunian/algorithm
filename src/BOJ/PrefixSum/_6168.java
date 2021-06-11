package BOJ.PrefixSum;

import java.util.Scanner;

public class _6168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int left = sum[i];
            int leftVal = left - i;
            int right = sum[n] - sum[i];
            int rightVal = (n - i) * 2 - right;
            res = Math.min(res, leftVal + rightVal);
        }
        System.out.println(res);
    }
}