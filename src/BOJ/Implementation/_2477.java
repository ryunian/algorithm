package BOJ.Implementation;

import java.util.Scanner;

// 참외밭
public class _2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[6];
        int w = 0;
        int h = 0;
        int ww = 0;
        int hh = 0;
        for (int i = 0; i < 6; i++) {
            sc.nextInt();
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (w < arr[i]) w = arr[i];
            } else {
                if (h < arr[i]) h = arr[i];
            }
        }

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (h == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
                    ww = arr[i];
                }
            } else {
                if (w == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
                    hh = arr[i];
                }
            }
        }
        System.out.println((w * h - ww * hh) * n);
    }
}
