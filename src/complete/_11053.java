package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1; i<=n;i++){
            arr[i] = sc.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
        int[] temp = new int[n+1];
        int result = 0;
        for(int i=1; i<n+1;i++){
            int max = 0;
            for(int j=0; j<i;j++){
                if(arr[i]>arr[j] && max<temp[j]){
                    max = temp[j];
                }
            }
            temp[i] = max+1;
            result = temp[i] > result ? temp[i] : result;
        }
//        System.out.println(Arrays.toString(temp));
        System.out.println(result);
    }
}
