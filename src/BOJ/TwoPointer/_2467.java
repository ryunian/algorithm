package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투포인터 이용
public class _2467 {
    static int x, y, val = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        while (start < end) {
            int a = arr[start] + arr[end];
            if (val > Math.abs(a)) {
                x = arr[start];
                y = arr[end];
                val = Math.abs(a);
            }
            if (val == 0) break;
            if (a > 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(x + " " + y);
    }

}
