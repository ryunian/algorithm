package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세용액
public class _2473 {
    static int n;
    static long min = Long.MAX_VALUE;
    static long[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        result = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        toPoint();
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    private static void toPoint() {
        long sum;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                sum = arr[i] + arr[j] + arr[k];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result[0] = arr[i];
                    result[1] = arr[j];
                    result[2] = arr[k];
                }
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    return;
                }
            }
        }
    }

}
