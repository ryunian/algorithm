package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294 {
    static int n, m, INF = 100001;
    static int[] coin, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[m+1]; // dp[i] : i원을 만드는데 동전의 최소 사용 횟수
        Arrays.fill(dp, -1);
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int res = solve(m);
        System.out.println(res == INF ? -1 : res);
    }

    private static int solve(int money) {
        // 기저사례
        // cnt == 0 : 0원을 만드는데 필요한 횟수는 0
        // cnt < 0 : 불가능한 경우
        if (money <= 0) return money == 0 ? 0 : INF;

        // 메모이제이션
        int ret = dp[money];
        if (ret != -1) return ret;

        ret = INF;
        for (int j = 0; j < n; j++) {
            ret = Math.min(ret, solve(money - coin[j]) +1);
        }

        return dp[money] = ret;
    }
}
