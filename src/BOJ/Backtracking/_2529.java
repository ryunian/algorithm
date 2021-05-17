package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2529 {
    static long minVal = Long.MAX_VALUE;
    static long maxVal = Long.MIN_VALUE;
    static int n;
    static String minStr, maxStr;
    static String[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        visit = new boolean[10];
        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            solve(i + "", i, 0);
            visit[i] = false;
        }
        System.out.println(maxStr);
        System.out.println(minStr);
    }

    private static void solve(String val, int prev, int idx) {
        if (idx == n) {
            long x = Long.parseLong(val);
            if (minVal > x) {
                minVal = x;
                minStr = val;
            }
            if (maxVal < x) {
                maxVal = x;
                maxStr = val;
            }
            return;
        }
        for (int next = 0; next < 10; next++) {
            if (!visit[next] && isTrue(prev, next, idx)) {
                visit[next] = true;
                solve(val + next, next, idx + 1);
                visit[next] = false;
            }
        }
    }

    private static boolean isTrue(int prev, int next, int idx) {
        if (arr[idx].equals("<")) {
            return prev < next;
        } else {
            return prev > next;
        }
    }
}
