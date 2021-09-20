package BOJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 3
public class _12738 {
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

        System.out.println(solve());
    }

    private static int solve() {
        int idx = 0;
        lis[0] = arr[0];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (lis[idx] < val) {
                lis[++idx] = val;
            } else {
                int target = lowerBound(0, idx, val);
                lis[target] = val;
            }
        }
        return idx + 1;
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
