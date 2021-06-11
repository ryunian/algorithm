package BOJ.PrefixSum;

import java.util.Scanner;

public class _5874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int[] sum = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int x = 0;
            if(arr[i-1] == ')' && arr[i] == ')'){
                x = 1;
            }
            sum[i] = sum[i-1] + x;
        }

        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == '(' && arr[i] == '('){
                res += sum[arr.length-1] - sum[i];
            }
        }
        System.out.println(res);
    }
}