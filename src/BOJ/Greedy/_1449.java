package BOJ.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class _1449 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물이 새는곳의 개수
        int l = sc.nextInt(); // 테이프의 길이

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int tape = arr[0] + l -1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(tape < arr[i]){
                cnt ++;
                tape = arr[i] + l -1;
            }

        }
        System.out.println(cnt);
    }
}
/*
4 2
1 2 100 101
>> 2
*/
