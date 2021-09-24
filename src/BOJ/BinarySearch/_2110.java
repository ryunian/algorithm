package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
public class _2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1];
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int prev = arr[0];
            for (int i = 1; i < n; i++) {
                int val = arr[i] - prev;
                if (val >= mid) {
                    cnt++;
                    prev = arr[i];
                }
            }
            if (cnt >= m) {
                left = mid + 1;
                res = Math.max(res, mid);
            } else if (cnt < m) {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
}
