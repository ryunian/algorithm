package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _20166 {
    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int n, m;
    private static char[][] map;
    private static Map<String, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        hashMap = new HashMap<>();
        String[] iter = new String[k];
        for (int i = 0; i < k; i++) {
            iter[i] = br.readLine();
            hashMap.put(iter[i], 0);
        }
        solve();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(hashMap.get(iter[i])).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, map[i][j] + "");
            }
        }
    }

    private static void dfs(int x, int y, String s) {
        if(hashMap.get(s) != null){
            int cnt = hashMap.get(s);
            hashMap.put(s, cnt+1);
        }

        if(s.length() >= 5){
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx == -1) nx = n - 1;
            if (nx == n) nx = 0;
            if (ny == -1) ny = m - 1;
            if (ny == m) ny = 0;
            dfs(nx, ny, s + map[nx][ny]);
        }
    }
}
