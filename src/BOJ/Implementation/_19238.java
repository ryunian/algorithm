package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 스타트 택시
public class _19238 {
    static boolean isok = true;
    static int n, m, oil, sx, sy, ex, ey, INF = 987654321;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr, visit;
    static HashMap<Node, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());
        visit = new int[n + 1][n + 1];
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[a][b] = 2;
            map.put(new Node(a, b, 0), new Node(c, d, 0));
        }

        while (m-- > 0) {
            solve(true);
            solve(false);
            if (!isok) break;
        }
        System.out.println(isok ? oil : -1);
    }

    private static void solve(boolean flag) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(sx, sy, 0));
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visit[i], INF);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (flag && arr[cur.x][cur.y] == 2) {
                Node node = map.get(cur);
                sx = cur.x;
                sy = cur.y;
                ex = node.x;
                ey = node.y;
                oil = oil - cur.cost;
                arr[cur.x][cur.y] = 0;
                return;
            } else if (!flag && cur.x == ex && cur.y == ey) {
                sx = cur.x;
                sy = cur.y;
                oil += cur.cost;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ncost = cur.cost + 1;
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;
                if (arr[nx][ny] == 1 || oil - ncost < 0) continue;
                if (visit[nx][ny] > ncost) {
                    visit[nx][ny] = ncost;
                    queue.add(new Node(nx, ny, ncost));
                }
            }
        }
        isok = false;
    }


    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Node o) {
            if (cost != o.cost) return cost - o.cost;
            if (x != o.x) return x - o.x;
            return y - o.y;
        }
    }
}
