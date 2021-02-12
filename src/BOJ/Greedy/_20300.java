package BOJ.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class _20300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        long res = 0;
        int left = 0;
        int right = n-1;
        if(n%2 == 1){
            res = arr[n-1];
            right--;
        }
        while (left < right){
            res = Math.max(res, arr[left++]+arr[right--]);
        }
        System.out.println(res);
    }
}
