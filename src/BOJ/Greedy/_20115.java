package BOJ.Greedy;

import java.util.Scanner;

public class _20115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Double[] arr = new Double[n];
        Double max = Double.valueOf(0);
        int idx = -1;
        for (int i = 0; i <n; i++) {
            Double x = sc.nextDouble();
            arr[i] = x;
            if(x > max){
                max = x;
                idx = i;
            }
        }
        double res = arr[idx];
        for (int i = n-1; i >= 0; i--) {
            if(i == idx) continue;
            res += arr[i]/2;
        }
        System.out.println(res);
    }
}
