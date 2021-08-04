package BOJ.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class _2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] arr = new int[10];
        while (tc-- > 0){
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);
        }
    }
}
