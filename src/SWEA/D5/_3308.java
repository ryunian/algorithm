package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최장 증가 부분 수열 (Hard)
public class _3308 {
    static int n;
    static int[] arr, lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.printf("#%d %d\n", tc, solve());
        }
    }

    private static int solve() {
        int idx = 0;
        lis = new int[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (lis[idx] < val) {
                lis[++idx] = val;
            } else {
                int target = lowerBound(0, idx, val);
                lis[target] = val;
            }
        }
        return idx;
    }

    private static int lowerBound(int left, int right, int val) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < val) {
                left++;
            } else {
                right--;
            }
        }
        return right;
    }
}
