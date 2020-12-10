package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12865 {
    private static class Backpack {
        int weight;
        int pride;

        public Backpack(String weight, String pride) {
            this.weight = Integer.parseInt(weight);
            this.pride = Integer.parseInt(pride);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Backpack[] arr = new Backpack[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Backpack(st.nextToken(), st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1.weight - o2.weight);
//        for(Backpack a : arr){
//            System.out.println(a.weight+" "+a.pride);
//        }

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int a = dp[i-1][j];
                if(arr[i-1].weight <= j){
                    int b = arr[i-1].pride+ dp[i-1][j-arr[i-1].weight];
                    dp[i][j] = Math.max(a,b);
                }else{
                    dp[i][j] = a;
                }
            }
        }
//        for(int[] x : dp){
//            for(int y : x){
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n][m]);
    }
}
