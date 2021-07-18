package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 300;
        int[][] arr = new int[max + 1][max + 1];
        int[][] dp = new int[max + 1][max + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cal = m - a - b;
            arr[a][b] = cal < 0 ? 0 : cal;
        }

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                int a = i == 0 ? 0 : dp[i - 1][j];
                int b = j == 0 ? 0 : dp[i][j - 1];
                dp[i][j] = Math.max(a, b) + arr[i][j];
            }
        }
        System.out.println(dp[max][max]);
    }
}
