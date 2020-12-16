package BOJ.Dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class _11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Matrix[] matrix = new Matrix[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[i] = new Matrix(a, b);
        }
        int INF = 987654321;
        int[][] dp = new int[n + 1][n + 1];

        for (int m = 2; m <= n; m++) {
            for (int i = 1, j = m; j <= n; i++, j++) {
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + matrix[i].x * matrix[k].y * matrix[j].y);
                }
            }
        }
        System.out.println(dp[1][n]);
    }

    private static class Matrix {
        int x;
        int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*
4
5 3
3 2
2 6
6 4

000 000 000 000 000
000 000  30  90 118
000 000 000  36  72
000 000 000 000  48
000 000 000 000 000
 */