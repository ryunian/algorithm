package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class _9229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int tc = 1; tc <= test; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Integer[] arr = new Integer[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr, (o1, o2) -> o2 - o1);

            int res = -1;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] >= m) continue;

                for (int j = i + 1; j < n; j++) {
                    if (arr[i] + arr[j] <= m) {
                        res = Math.max(res, arr[i] + arr[j]);
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
