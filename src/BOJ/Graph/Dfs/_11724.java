package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724 {
    static int n;
    static boolean[][] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        n = Integer.parseInt(st.nextToken());

        // 간선의 개수
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][n];
        check = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = arr[y][x] = true;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int i) {
        if(check[i]){
            return;
        }
        check[i] = true;

        for (int k = 0; k < n; k++) {
            if (arr[i][k]) {
                dfs(k);
            }
        }
    }
}
