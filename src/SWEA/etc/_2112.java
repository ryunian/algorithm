package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 보호 필름
public class _2112 {
    static int n, m, k, res;
    static int[][] arr, map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            res = Integer.MAX_VALUE;
            arr = new int[n][m];
            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int val = Integer.parseInt(st.nextToken()) == 0 ? -1 : 1;
                    map[i][j] = arr[i][j] = val;
                }
            }

            solve(0, 0);
            sb.append(String.format("#%d %d\n", tc, res));
        }
        System.out.print(sb);
    }


    private static void solve(int idx, int cnt) {
        if (cnt >= res) return;
        if (idx == n) {
            boolean isok = true;
            for (int i = 0; i < m; i++) {
                int max = 1;
                int tmp = 1;
                for (int j = 1; j < n; j++) {
                    if (arr[j][i] == arr[j - 1][i]) tmp++;
                    else tmp = 1;
                    if (max < tmp) max = tmp;
                }
                if (max < k) {
                    isok = false;
                    break;
                }
            }
            if (isok) res = Math.min(res, cnt);
            return;
        }
        solve(idx + 1, cnt);
        Arrays.fill(arr[idx], -1);
        solve(idx + 1, cnt + 1);
        Arrays.fill(arr[idx], 1);
        solve(idx + 1, cnt + 1);
        for (int i = 0; i < m; i++) {
            arr[idx][i] = map[idx][i];
        }
    }
}
