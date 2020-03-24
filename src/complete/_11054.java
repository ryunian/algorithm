package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] temp1 = new int[n + 2];
        int[] temp2 = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i]){
                    max = temp1[j] > max ? temp1[j] : max;
                }
            }
            temp1[i] = ++max;
        }
        for (int i = n; i >= 1; i--) {
            int max = 0;
            for (int j = n+1; j > i; j--) {
                if(arr[j]<arr[i]){
                    max = temp2[j] > max ? temp2[j] : max;
                }
            }
            temp2[i] = ++max;
        }
        int result = 0;
        for(int i=1; i<=n;i++){
            int x = temp1[i]+temp2[i]-1;
            result = x > result ? x : result;
        }
        System.out.println(result);
//        System.out.println(Arrays.toString(temp1));
//        System.out.println(Arrays.toString(temp2));
    }
}
