package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1051 {
    static int n, m, dis = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                solve(i, j, dis + 1);
            }
        }
        dis++;
        System.out.println(dis * dis);
    }

    private static void solve(int x, int y, int plus) {
        int num = map[x][y];
        int nx = x + plus;
        int ny = y + plus;
        if (nx >= n || ny >= m) return;
        if (map[x][ny] == num && map[nx][y] == num && map[nx][ny] == num) {
            dis = plus;
        }
        solve(x, y, plus + 1);
    }
}
