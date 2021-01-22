package BOJ.etc;

import java.util.Scanner;

public class _9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] x = sc.next().split("");
        String[] y = sc.next().split("");
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
        int[][] dp = new int[x.length+1][y.length+1];
        for(int i=1; i<=x.length;i++){
            for(int j=1; j<=y.length;j++){
                if(x[i-1].equals(y[j-1])){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        for(int[] i : dp){
//            for(int j : i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[x.length][y.length]);
    }
}
