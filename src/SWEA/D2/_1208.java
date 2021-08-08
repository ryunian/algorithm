package SWEA.D2;

import java.util.Scanner;

public class _1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();

            int[] arr = new int[100 + 1];

            for (int i = 0; i < 100; i++) {
                int x = sc.nextInt();
                arr[x]++;
            }
            int left = 0;
            int right = 100;
            int cnt = 0;
            while (cnt < n && left < right) {
                if (arr[left] != 0 && arr[right] != 0) {
                    arr[right]--;
                    arr[right - 1]++;
                    arr[left]--;
                    arr[left + 1]++;
                    cnt++;
                }
                if (arr[left] == 0) left++;
                if (arr[right] == 0) right--;
            }
            System.out.println("#" + tc + " " + (right - left));
            return;
        }
    }
}