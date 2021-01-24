package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1654 {
    static int n, m;
    static long max = 0;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            arr[i] = x;
            sum += x;
        }
        solve(1, sum / m);
        System.out.println(max);
    }

    private static void solve(long left, long right) {
        if (left > right) return;

        long mid = (left + right) / 2;

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] / mid;
        }
        if (cnt < m) {
            solve(left, mid - 1);
        } else {
            max = Math.max(max, mid);
            solve(mid + 1, right);
        }
    }
}
