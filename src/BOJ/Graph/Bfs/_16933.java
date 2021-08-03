package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16933 {
    static int n, m, k;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0};

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
        queue.add(new Node(0, 0, 0, 1, 1));
        boolean[][][] visit = new boolean[n][m][k + 1];
        visit[0][0][0] = true;


        int INF = 987654321;
        int res = INF;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                res = Math.min(res, cur.cost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nd = cur.day * -1;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 방문하지 않은 공간
                if (!visit[nx][ny][cur.k] && arr[nx][ny] == 0) {
                    visit[nx][ny][cur.k] = true;
                    queue.add(new Node(nx, ny, cur.k, nd, cur.cost + 1));
                }

                // 벽
                int nk = cur.k + 1;
                if (nk <= k && arr[nx][ny] == 1 && !visit[nx][ny][nk]) {
                    // 낮 일떄
                    if (cur.day == 1) {
                        visit[nx][ny][nk] = true;
                        queue.add(new Node(nx, ny, nk, -1, cur.cost + 1));
                    }
                    // 저녁 일떄
                    else if (cur.day == -1) {
                        // cost 계산을 통해 nx,ny 를 넣을경우
                        // 결과가 높은값이 먼저 나오게 됨으로 주의
                        queue.add(new Node(cur.x, cur.y, cur.k, 1, cur.cost + 1));
                    }
                }
            }
        }
        System.out.println(res == INF ? -1 : res);
    }

    static class Node {
        int x;
        int y;
        int k;
        int day;
        int cost;

        public Node(int x, int y, int k, int day, int cost) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.day = day;
            this.cost = cost;
        }
    }
}
