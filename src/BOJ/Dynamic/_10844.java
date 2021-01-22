package BOJ.Dynamic;

import java.util.Scanner;

public class _10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000000;
        long[][] arr = new long[n+1][10];
        // x축 자릿수
        // y축 앞자리 숫자별로 정답이 나오는 갯수 ( 0 예외 )
        /*
        \  0  1  2  3  4  5  6  7  8  9  sum
        1  1  1  1  1  1  1  1  1  1  1    9
        2  1  2  2  2  2  2  2  2  2  1   17
        3  2  3  4  4  4  4  4  4  3  2   32
        4  3  6  7  8  8  8  8  7  6  3
        5  6 10 14 15 16 16 15 14 10  6
        6 10                         11
        */
        for(int i=0;i<=9;i++){
            arr[1][i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                if(j==0){
                    arr[i][j] = arr[i-1][j+1] % mod;
                }else if(j==9){
                    arr[i][j] = arr[i-1][j-1] % mod;
                }else{
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % mod;
                }
            }
        }

//        for(long[] i : arr){
//            for(long j : i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
        long result = 0;
        for(int i=1;i<=9;i++){
            result += arr[n][i];
        }
        System.out.println(result%mod);
    }
}
