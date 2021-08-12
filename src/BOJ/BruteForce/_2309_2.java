package BOJ.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

// 일곱 난쟁이
public class _2309_2 {
    static int n = 7, m = 9;
    static int[] res = new int[n];
    static int[] arr = new int[m];
    static boolean[] visit = new boolean[m];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        solve(0);
    }

    private static void solve(int cnt) {
        if (cnt == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += res[i];
            }
            if (sum == 100) {
                for (int i = 0; i < n; i++) {
                    System.out.println(res[i]);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < m; i++) {
            if (!visit[i]) {
                visit[i] = true;
                res[cnt] = arr[i];
                solve(cnt + 1);
                visit[i] = false;
            }
        }
    }
}