package SWEA.D4;

import java.util.*;

// 키 순서
public class _5643 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int INF = 987654321;

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(arr[i], INF);
            }

            while (m-- > 0) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                arr[a][b] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                boolean isok = true;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (arr[i][j] == INF && arr[j][i] == INF) {
                        isok = false;
                    }
                }
                res += isok ? 1 : 0;
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
