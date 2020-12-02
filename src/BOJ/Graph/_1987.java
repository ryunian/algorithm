package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 {
    static boolean[] visit = new boolean[26];
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static int n, m;
    static int result = Integer.MIN_VALUE;
//    static PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = x.charAt(j);
            }
        }

        /*for (char[] x : map) {
            for (char y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }*/

        dfs(0, 0, 1);
//        System.out.println(queue.peek());
        System.out.println(result);
    }

    private static void dfs(int x, int y, int cnt) {
        result = Math.max(result, cnt);
//        queue.add(cnt);

        visit[map[x][y] - 65] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];
            if (nx <= -1 || ny <= -1 || nx >= n || ny >= m) {
                continue;
            }
            if (!visit[map[nx][ny] - 65]) {
                visit[map[nx][ny] - 65] = true;
                dfs(nx, ny, cnt + 1);
                visit[map[nx][ny] - 65] = false;
            }
        }
    }
}
// 'A' - 65 = 0
