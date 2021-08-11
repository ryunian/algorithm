package BOJ.Recursion;

import java.util.Scanner;

// 도영이가 만든 맛있는 음식
public class _2961 {
    static int n;
    static int res = Integer.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        solve(0, 1, 0, 0);
        System.out.println(res);
    }

    private static void solve(int idx, int a, int b, int sel) {
        if (idx == n) {
            if (sel > 0) {
                res = Math.min(res, Math.abs(a - b));
            }
            return;
        }
        solve(idx + 1, a * arr[idx][0], b + arr[idx][1], sel + 1);
        solve(idx + 1, a, b, sel);
    }
}
