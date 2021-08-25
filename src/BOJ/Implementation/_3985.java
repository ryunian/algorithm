package BOJ.Implementation;

import java.util.Scanner;

// 롤 케이크
public class _3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int max = 0;
        int idx = 0;
        int res = 0;
        int len = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int tmp = 0;
            for (int j = a; j <= b; j++) {
                if (arr[j] == 0) {
                    tmp++;
                    arr[j]++;
                }
            }
            if (len < b - a + 1) {
                len = b - a + 1;
                res = i + 1;
            }
            if (max < tmp) {
                max = tmp;
                idx = i + 1;
            }
        }
        System.out.println(res);
        System.out.println(idx);
    }
}
