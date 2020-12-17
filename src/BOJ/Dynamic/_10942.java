package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수열의 크기
        int n = Integer.parseInt(br.readLine());
        // 칠판에 적은 수
        int[] arr = new int[n + 1];
        // 메모제이션
        int[][] dp = new int[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1, j = k; j <= n; i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    dp[i][j-1] = 1;
                    continue;
                }
                // i (시작) j (끝)이 같을 경우
                // 왼쪽대각선 아래가 1 (팰린드롬) 일 경우
                // i j 는 팰린드롬이다
                if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        // 쿼리
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(dp[a][b]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void print(int[][] dp){
        for (int[] a : dp) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
