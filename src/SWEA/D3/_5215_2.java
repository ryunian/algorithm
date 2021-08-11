package SWEA.D3;

import java.util.Scanner;

// 햄버거 다이어트
public class _5215_2 {
    static int n, k, res;
    static boolean[] visit;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            res = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n][n];
            visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            solve(0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static void solve(int idx) {
        if (idx == n) {
            int score = 0;
            int kal = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    score += arr[i][0];
                    kal += arr[i][1];
                }
            }
            if (score > res && kal <= k) {
                res = score;
            }
            return;
        }
        visit[idx] = true;
        solve(idx + 1);
        visit[idx] = false;
        solve(idx + 1);
    }
}
