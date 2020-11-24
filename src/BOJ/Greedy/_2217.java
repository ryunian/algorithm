package BOJ.Greedy;

import java.util.*;

public class _2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int cnt = 0;
        int result = 0;
        // 내림차순으로 정렬 했으므로 배열의 마지막부터 순회
        for (int i = n - 1; i >= 0; i--) {
            cnt++; // 로프 수
            int size = arr[i] * cnt;
            if(result < size ) result = size;
        }
        System.out.println(result);
    }
}
