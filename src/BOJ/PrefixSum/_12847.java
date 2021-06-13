package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long[] sum = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        long res = sum[m-1];
        for (int i = n-1; i >= m; i--) {
            res = Math.max(res, sum[i] - sum[i-m]);
        }

        System.out.println(res);
    }
}
