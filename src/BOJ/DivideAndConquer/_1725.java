package BOJ.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1725 {
    static int n;
    static int[] arr;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        solve(0, n - 1);
        System.out.println(res);
    }

    private static void solve(int left, int right) {
        if (left == right) {
            res = Math.max(res, arr[left]);
            return;
        }

        int mid = (left + right) / 2;
        solve(left, mid);
        solve(mid + 1, right);

        int low = mid;
        int high = mid + 1;
        int height = Math.min(arr[low], arr[high]);

        res = Math.max(res, height * 2);
        while (left < low || high < right) {
            if (high < right && (low == left || arr[low - 1] < arr[high + 1])) {
                high++;
                height = Math.min(height, arr[high]);
            } else {
                low--;
                height = Math.min(height, arr[low]);
            }
            res = Math.max(res, height * (high - low + 1));
        }
    }
}