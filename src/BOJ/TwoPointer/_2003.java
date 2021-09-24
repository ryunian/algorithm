package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합 2
public class _2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (true) {
            if (sum >= m) {
                sum -= arr[left++];
            } else {
                if (right == n) break;
                sum += arr[right++];
            }
            if (sum == m) res++;
        }
        System.out.println(res);
    }
}
