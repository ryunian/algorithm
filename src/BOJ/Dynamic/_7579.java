package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n+1];
        int[] cost = new int[n+1];
        int maxCost = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        StringTokenizer st3 = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st3.nextToken());
            cost[i] = a;
            maxCost += a;
        }
//        System.out.println(Arrays.toString(memory));
//        System.out.println(Arrays.toString(cost));
//        System.out.println(maxCost);
        int[][] dp = new int[maxCost+1][n+1];

        loop:
        for (int i = 1; i <= maxCost; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                System.out.println(dp[i-cost[i]][j-1]);
                if(i-cost[j] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-cost[j]][j-1]+ memory[j]);
                }

                System.out.print(dp[i][j]+" ");

                if(dp[i][j] >= m){
//                    System.out.println();
//                    System.out.println(i);
//                    break loop;
                }
            }
            System.out.println();
        }
    }
}
