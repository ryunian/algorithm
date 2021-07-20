package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20951 {
    private static int MOD = (int) Math.pow(10, 9) + 7;
    private static ArrayList<Integer>[] list;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향
            list[a].add(b);
            list[b].add(a);
        }
        dp = new int[7 + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= 7 ; i++) {
            for (int j = 1; j <= n; j++) {
                for (int x : list[j]) {
                    dp[i][j] += dp[i-1][x];
                    dp[i][j] %= MOD;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <=n; i++) {
            res += dp[7][i];
            res %= MOD;
        }
        System.out.println(res);
    }
}
