package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            int idxA = i;
            int idxB = i;
            while (idxA < n) {
                if (dp[idxA][0] != 1) break;
                if (arr[idxA] >= arr[idxA - 1]) {
                    dp[idxA][0] = dp[idxA - 1][0] + 1;
                } else {
                    break;
                }
            }
            while (idxB < n) {
                if (dp[idxB][1] != 1) break;
                if (arr[idxB] <= arr[idxB - 1]) {
                    dp[idxB][1] = dp[idxB - 1][1] + 1;
                } else {
                    break;
                }
            }
            res = Math.max(res, Math.max(dp[idxA][0], dp[idxB][1]));
        }
        System.out.println(res);
    }

}
