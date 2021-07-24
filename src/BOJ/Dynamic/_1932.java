package BOJ.Dynamic;

import java.util.Scanner;

public class _1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
//        int[][] temp = new int[num][num];
        for(int i=0; i<num; i++){
            for(int j=0;j<i+1;j++){
                arr[i][j] = sc.nextInt();
            }
        }
//        for(int[] i : arr){
//            for(int j : i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
        for(int i=num-2; i>=0; i--){ // num-1
            for(int j=0;j<i+1;j++){
                arr[i][j] = Math.max(arr[i+1][j],arr[i+1][j+1]) + arr[i][j];
//                temp[i][j] = 1;
            }
        }
//        System.out.println();
//        for(int[] i : arr){
//            for(int j : i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
        System.out.println(arr[0][0]);
    }
}
