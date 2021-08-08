package SWEA.D2;

import java.util.Scanner;

public class _1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr;
        while (t-- > 0){
            int n = sc.nextInt();
            int maxCnt = 0;
            int maxScore = 0;
            arr = new int[101];
            for (int i = 0; i < 1000; i++) {
                int score = sc.nextInt();
                arr[score]++;
                if(maxCnt <= arr[score]){
                    maxCnt = arr[score];
                    maxScore = score;
                }
            }
            System.out.printf("#%d %d\n",n,maxScore);
        }
    }
}
