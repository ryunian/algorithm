package complete;

import java.util.Scanner;

public class _9461 {
    static long[] arr = new long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr[1] = 1; arr[2] = 1; arr[3]=1;
        int n = sc.nextInt();
        for(int i=0; i<n;i++){
            int x = sc.nextInt();
            function(x);
            System.out.println(arr[x]);
        }
    }
    private static void function(int x) {
        for(int i=4;i<=x;i++){
            arr[i] = arr[i-2] + arr[i-3];
        }
    }
}
