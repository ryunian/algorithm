package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] temp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        function(n, arr, temp);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(temp));
        System.out.println(temp[n]);
    }

    private static void function(int n, int[] arr, int[] temp) {
        temp[1] = arr[0] + arr[1];
        if (n == 1) return;
        temp[2] = arr[1] + arr[2];
        if (n == 2) return;
        for (int i = 3; i <= n; i++) {
            int x = Math.max(arr[i] + temp[i - 2], temp[i - 1]);
            temp[i] = Math.max(x, arr[i] + arr[i - 1] + temp[i - 3]);
        }
    }
}
