package SWEA.D3;

import java.util.Scanner;

// 부분 수열의 합
public class _2817 {
    static int n, m, cnt, sum;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n];
            visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cnt = 0;
            sum = 0;

            solve(0);
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }

    private static void solve(int idx) {
        if (idx == arr.length) {
            if (sum == m) cnt++;
            return;
        }
        sum = sum + arr[idx]; // visit[idx] = true; //
        solve(idx + 1);
        sum = sum - arr[idx]; // visit[idx] = false;

        solve(idx + 1);
    }
    private static void solve2(int idx, int sum) {
        if (idx == arr.length) {
            if (sum == m) cnt++;
            return;
        }
        solve2(idx + 1, sum + arr[idx]);
        solve2(idx + 1, sum);
    }
}
