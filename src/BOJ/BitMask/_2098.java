package BOJ.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2098 {
    static int n, INF = 987654321;
    static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        dp = new int[n][1<<n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = tsp(0, 1);
        System.out.println(result);
    }

    private static int tsp(int cur, int visit) {
        if(visit == (1<<n)-1){
            // input에서 갈 수 없는 경우 0이 주어진다.
            if(matrix[cur][0] == 0){
                return INF;
            }
            return matrix[cur][0];
        }
        // 이미 방문한적이 있을 경우
        if(dp[cur][visit] != 0){
            return dp[cur][visit];
        }

        dp[cur][visit] = INF;
        for (int i = 0; i < n; i++) {
            int next = 1 << i;
            // 길이 없거나,이미 간곳이면 넘어간다
            // ex) 1100 & 1000 = 1000 , 3번째는 이미 방문했다.
            if(matrix[cur][i] == 0 || (visit & next) != 0){
                continue;
            }

            dp[cur][visit] = Math.min(dp[cur][visit], tsp(i, visit | next ) + matrix[cur][i]);
        }

        return dp[cur][visit];
    }
}
