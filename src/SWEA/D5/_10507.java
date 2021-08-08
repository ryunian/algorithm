package SWEA.D5;

import java.util.Scanner;

public class _10507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] arr;
        int[] sum;

        for (int i = 1; i <= test; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            arr = new int[n];
            // 번호크기 + p의 크기 + 기타 3
            sum = new int[1000000 + 200000 + 3];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt() + 1;
                sum[arr[j]]++;
            }

            // 누적합
            for (int j = 1; j < sum.length; j++) {
                sum[j] = sum[j] + sum[j - 1];
            }

            int max = 0;
            for (int j = 0; j < arr.length; j++) {
                int idx = arr[j];
                int left = idx - 1;
                int right = idx + m - 1;

                // 구간내에 공부한시간만큼 움직인다.
                while (sum[left] < sum[right]) {
                    int tmp = sum[right] - sum[left];
                    left = right;
                    right = right + tmp;
                }
                // 다음날이 공부한 시간일 경우
                while (sum[right] < sum[right + 1]) {
                    right++;
                }
                max = Math.max(max, right - idx + 1);
            }
            System.out.printf("#%d %d\n", i, max);
        }
    }
}
