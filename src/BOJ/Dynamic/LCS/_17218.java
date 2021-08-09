package BOJ.Dynamic.LCS;

import java.util.Scanner;

// 최장 공통 부분수열 ( LCS )
public class _17218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr1 = sc.nextLine().toCharArray();
        char[] arr2 = sc.nextLine().toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i < arr1.length+1; i++) {
            for (int j = 1; j < arr2.length+1; j++) {
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int x = arr1.length;
        int y = arr2.length;
        int val = dp[x][y];
        StringBuilder sb = new StringBuilder();
        while (x > 0 && y > 0){
            if(dp[x-1][y] == val){
                x--;
            }else if(dp[x][y-1]== val){
                y--;
            }else if(dp[x-1][y-1] == val-1){
                sb.insert(0, arr1[x-1]);
                val--;
                x--;
                y--;
            }
        }
        System.out.println(sb.toString());
    }
}
