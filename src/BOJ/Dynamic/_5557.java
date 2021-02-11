package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5557 {
    static int n;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new long[n+1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        // 끝자리는 부호가 들어가지 않으므로 n-1 에 시작한다.
        System.out.println(solve(n-1, arr[n]));
    }

    private static long solve(int idx, int ans) {
        // idx가 1 이며, ans 값이 arr[1] 일떄, 경우의 수를 추가한다.
        if(idx == 1 && ans == arr[1]){
            return dp[idx][ans] = 1;
        }
        // 등호가 올바르지 않으므로 0을 반환한다.
        if(idx == 1 && ans != arr[1]){
            return dp[idx][ans] = 0;
        }

        // 메모이제이션
        long ret = dp[idx][ans];
        if (ret != -1) return ret;

        // 초기 경우의수는 0
        ret = 0;

        // ans 에 - 가 붙은 값이 20 보다 작아야 된다.
        if (ans - arr[idx] >= 0) {
            ret += solve(idx - 1, ans - arr[idx]);
        }
        // ans 에 + 가 붙은 값이 20 보다 작아야 된다.
        if (ans + arr[idx] <= 20) {
            ret += solve(idx - 1, ans + arr[idx]);
        }

        return dp[idx][ans] = ret;
    }

}
