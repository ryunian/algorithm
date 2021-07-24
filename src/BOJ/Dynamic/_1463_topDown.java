package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _1463_topDown {
    static int[] dp;
    static int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        dp = new int[x + 1];
        // min값을 찾는 것이므로 아주 큰값으로 초기화한다.
        Arrays.fill(dp, INF);
        int res = solve(x);

        System.out.println(res);
        for (int i = 1; i <= 10; i++) {
            System.out.println("dp["+i+"] 일때 최소 횟수 = " + dp[i]);
        }
    }

    // top-down
    // dp[x] = 값이 x일떄 최소 연산횟수
    //
    /*
        x = 10일떄
        dp[1] 일때 최소 횟수 = 987654321
        // 1이면 바로 0이 반환되므로 저장되지 않았음, 연산전에 dp[1] = 0으로 초기화 해줘도 좋음
        dp[2] 일때 최소 횟수 = 1
        dp[3] 일때 최소 횟수 = 1
        dp[4] 일때 최소 횟수 = 2
        dp[5] 일때 최소 횟수 = 3
        dp[6] 일때 최소 횟수 = 2
        dp[7] 일때 최소 횟수 = 3
        dp[8] 일때 최소 횟수 = 3
        dp[9] 일때 최소 횟수 = 2
        dp[10] 일때 최소 횟수 = 3
     */
    private static int solve(int x) {
        if (x < 1) return INF; // x값 보다 낮아지면 소용없으므로 초기값 반환
        if (x == 1) return 0;

        int ret = dp[x];
        // 메모이제이션의 값이 초기값(INF) 이 아니면 이미 계산된것이므로 그값을 반환한다.
        if (ret != INF) return ret;

        // 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
        if (x % 3 == 0) {
            // x/3을 계산할경우 횟수가 늘어나므로 +1
            // 기존계산 (ret) 와 solve(x/3) + 1 한 결과중 최소값 비교
            ret = Math.min(solve(x / 3) + 1, ret);
        }

        // 2. X가 2로 나누어 떨어지면, 2로 나눈다.
        if (x % 2 == 0) {
            ret = Math.min(solve(x / 2) + 1, ret);
        }

        // 3. 1을 뺀다.
        ret = Math.min(solve(x - 1) + 1, ret);

        // 메모이제이션에 값을 저장하고 반환한다.
        return dp[x] = ret;
    }
}