package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9466 {
    static int result;
    static int[] arr, visit, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            arr = new int[m + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            visit = new int[m + 1];
            v = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (visit[j] == 0) {
                    dfs(j, j, 1);
                }
            }
            System.out.println(m - result);
//            System.out.println(Arrays.toString(v));
        }
    }

    private static void dfs(int start, int x, int cnt) {
        System.out.println(start);
        if (visit[x] != 0 ) {
            if (start == v[x]) {
//                System.out.println(start +" "+x+" "+arr[x]);
                result += cnt - visit[x];
            }
            return;
        }
        visit[x] = cnt;
        v[x] = start;

        dfs(start, arr[x], cnt + 1);
    }
}
