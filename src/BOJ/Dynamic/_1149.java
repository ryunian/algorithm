package BOJ.Dynamic;

import java.util.Scanner;

public class _1149 {
    static int[][] arr;
//    static int[][] temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        arr = new int[num+1][3];
//        temp = new int[num+1][3];
        for(int i=1; i<=num;i++){
            for(int j=0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
//        for(int[] i : arr){
//            for(int j : i) System.out.print(j+" ");
//            System.out.println();
//        }
        for(int i=1; i<=num;i++){
            arr[i][0] = arr[i][0] + Math.min(arr[i-1][1],arr[i-1][2]);
            arr[i][1] = arr[i][1] + Math.min(arr[i-1][0],arr[i-1][2]);
            arr[i][2] = arr[i][2] + Math.min(arr[i-1][0],arr[i-1][1]);
        }

//        for(int[] i : arr){
//            for(int j : i) System.out.print(j+" ");
//            System.out.println();
//        }

        int result = Math.min(arr[num][0],arr[num][1]);
        result = Math.min(result,arr[num][2]);
        System.out.println(result);
    }
}
