package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 501;
        int[] arr = new int[size]; // 501
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x] = y;
        }
        int max = 0;
        int[] temp = new int[size];
        for (int i = 1; i < size - 1; i++) {
            if (arr[i] == 0) continue;
            int x = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) x = temp[j] > x ? temp[j] : x;
            }
            temp[i] = ++x;
            max = max < temp[i] ? temp[i] : max;
        }
        System.out.println(n-max);

    }
}
