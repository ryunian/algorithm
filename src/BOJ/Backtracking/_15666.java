package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15666 {
    static int n, m;
    static int[] arr, tmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (tmp[cnt] != arr[i]) {
                tmp[cnt] = arr[i];
                solve(cnt + 1, i);
            }
        }
        System.out.print(sb.toString());
    }

    private static void solve(int cnt, int idx) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        tmp[cnt] = 0;
        for (int i = idx; i < n; i++) {
            if (tmp[cnt] != arr[i]) {
                tmp[cnt] = arr[i];
                solve(cnt + 1, i);
            }
        }
    }
}
