package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14442 {
    static int n, m, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        solve();
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        int[][][] visit = new int[n][m][k + 1];
        visit[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                System.out.println(visit[cur.x][cur.y][cur.k]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny][cur.k] == 0 && arr[nx][ny] == 0) {
                    visit[nx][ny][cur.k] = visit[cur.x][cur.y][cur.k] + 1;
                    queue.add(new Node(nx, ny, cur.k));
                }

                if (cur.k < k && visit[nx][ny][cur.k + 1] == 0 && arr[nx][ny] == 1) {
                    visit[nx][ny][cur.k + 1] = visit[cur.x][cur.y][cur.k] + 1;
                    queue.add(new Node(nx, ny, cur.k + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    private static class Node {
        int x;
        int y;
        int k;

        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}
