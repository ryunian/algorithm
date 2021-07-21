package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2468 {
    static int n, maxHeight = 0;
    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                maxHeight = Math.max(maxHeight, x);
            }
        }

        // 비가 안올경우도 있으므로 최소 1
        int res = 1;
        for (int i = 1; i <= maxHeight; i++) {
            int areaCnt = 0;
            visit = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > i && !visit[j][k]) {
                        solve(i, j, k);
                        areaCnt++;
                    }
                }
            }
            res = Math.max(res, areaCnt);
        }
        System.out.println(res);
    }

    private static void solve(int rain, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 침수되지 않은 지점이면서 방문하지 않은 곳
                if (map[nx][ny] > rain && !visit[nx][ny]) {
                    queue.add(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
