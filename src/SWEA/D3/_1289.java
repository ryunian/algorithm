package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // test case
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());

            // 재료갯수
            int n = Integer.parseInt(st.nextToken());
            // 제한 칼로리
            int l = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n + 1][2];
            int[][] dp = new int[n + 1][l + 1];

            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            // bottom-up
            for (int idx = 1; idx <= n; idx++) {
                for (int kal = 1; kal <= l; kal++) {
                    // 현재 재료를 사용하지 않았을 때의 최대값
                    int a = dp[idx - 1][kal];

                    if (arr[idx][1] <= kal) {
                        // 현재 재료의 점수 + (kal - 현재재료칼로리) 의 점수
                        int b = arr[idx][0] + dp[idx - 1][kal - arr[idx][1]];

                        dp[idx][kal] = Math.max(a, b);

                    } else {
                        // 들어갈수 없으므로 이전값만 저장
                        dp[idx][kal] = a;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(dp[n][l]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
