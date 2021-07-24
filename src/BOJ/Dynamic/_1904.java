package BOJ.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class _1904 {
    static int num;
    static int[] arr = new int[2];
    static int[] temp = new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        pibonachi(0);
        if(num==0){
            System.out.println(arr[0]);
        }else{
            System.out.println(arr[1]);
        }

    }

    private static void pibonachi(int i) {
        if (i == 0) {
            arr[i] = 0;
        }
        if (i == 1) {
            arr[i] = 1;
        }
        if (i >= 2) {
            temp[0] = arr[1];
            temp[1] = arr[0] + arr[1];
            temp[1] %= 15746;
            arr = Arrays.copyOf(temp, 2);
        }
        if (i <= num) {
            pibonachi(i + 1);
        }
    }
}
