package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _15663 {
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        int[] tmp = new int[m];
        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);

                visit[i] = true;
                tmp[cnt] = arr[i];
                solve(cnt + 1, tmp);
                visit[i] = false;
            }
        }
        System.out.print(sb.toString());
    }

    private static void solve(int cnt, int[] tmp) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i]+" ");
            }
            sb.append("\n");
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visit[i] && !set.contains(arr[i])) {
                set.add(arr[i]);

                visit[i] = true;
                tmp[cnt] = arr[i];
                solve( cnt + 1, tmp);
                visit[i] = false;
            }
        }
    }
}
