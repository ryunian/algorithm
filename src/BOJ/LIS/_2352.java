package BOJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 반도체 설계
public class _2352 {
    static int[] arr, lis;
    static int n;

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
            int val = arr[i];
            if (lis[idx] < val) {
                lis[++idx] = val;
            } else {
                int target = lowerBound(0, idx, val);
                lis[target] = val;
            }
        }
        System.out.println(idx + 1);
    }

    private static int lowerBound(int left, int right, int val) {
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
