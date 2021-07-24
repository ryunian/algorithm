package BOJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12015 {
    static int n;
    static int[] arr, lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    private static void solve() {
        int idx = 0;
        lis[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (lis[idx] < arr[i]) {
                lis[++idx] = arr[i];
            } else {
                int targetIdx = lowerbound(0, idx, arr[i]);
                lis[targetIdx] = arr[i];
            }
        }
        System.out.println(idx + 1);
    }

    private static int lowerbound(int left, int right, int val) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
