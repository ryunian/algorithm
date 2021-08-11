package SWEA.D3;

import java.util.Scanner;

// 햄버거 다이어트
public class _5215_3 {
    static int n, k, res;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            res = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            solve(0, 0, 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static void solve(int idx, int score, int kal) {
        if (kal > k) return;
        if (idx == n) {
            res = Math.max(res, score);
            return;
        }
        int ns = score + arr[idx][0];
        int nk = kal + arr[idx][1];
        solve(idx + 1, ns, nk);
        solve(idx + 1, score, kal);
    }
}
