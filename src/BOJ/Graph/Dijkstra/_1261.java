package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1261 {
    static int n, m, INF = 987654321;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        solve();
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static void solve() {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cnt));
        queue.add(new Node(0, 0, 0));
        int[][] visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], INF);
        }
        visit[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.x == n-1 && cur.y == m-1){
                System.out.println(cur.cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(visit[nx][ny] > visit[cur.x][cur.y] + map[nx][ny]){
                    visit[nx][ny] = visit[cur.x][cur.y] + map[nx][ny];
                    queue.add(new Node(nx, ny, visit[nx][ny]));
                }
            }
        }

    }
}
