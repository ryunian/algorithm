package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _2437 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int x = 1;
        for (int i = 0; i < n; i++) {
            if(x < arr[i]) break;
            x += arr[i];
        }
        System.out.println(x);
    }
}
