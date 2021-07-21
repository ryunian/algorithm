package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14497 {
    private static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int n, m, sx, sy, ex, ey;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = str.charAt(j - 1);
                if (c == '#' || c == '*') {
                    map[i][j] = '0';
                } else {
                    map[i][j] = c;
                }
            }
        }
        solve1();
//        sovle2();
    }

    // solve2 만들다보니 Node Class에 cost 추가...
    // solve1은 그대로 유지
    private static void solve1() {
        int[][] visit = new int[n + 1][m + 1];
        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], -1);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy));
        visit[sx][sy] = 0;

        int cnt = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == ex && cur.y == ey) {
                cnt = Math.min(cnt, visit[cur.x][cur.y]);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;
                int nextVal = map[nx][ny] - '0';

                if (visit[nx][ny] == -1) {
                    queue.add(new Node(nx, ny));
                    visit[nx][ny] = visit[cur.x][cur.y] + nextVal;

                } else if (visit[nx][ny] > visit[cur.x][cur.y] + nextVal) {
                    queue.add(new Node(nx, ny));
                    visit[nx][ny] = visit[cur.x][cur.y] + nextVal;
                }
            }
        }
        System.out.println(cnt + 1);
    }

    // 다익스트라
    private static void sovle2() {
        // 우선순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        int[][] tmp = new int[n + 1][m + 1];
        int INF = 987654321; // 무한대
        for (int i = 0; i < tmp.length; i++) {
            Arrays.fill(tmp[i], INF);
        }

        // 시작값
        queue.add(new Node(sx, sy, 0));
        tmp[sx][sy] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == ex && cur.y == ey) {
                System.out.println(cur.cost + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                // 예외처리
                if (nx <= 0 || ny <= 0 || nx > n || ny > m) continue;

                int nextCost = map[nx][ny] - '0';

                // 1을 만나횟수가 더 적을 경우
                if (tmp[nx][ny] > nextCost + cur.cost) {
                    tmp[nx][ny] = nextCost + cur.cost;
                    queue.add(new Node(nx, ny, tmp[nx][ny]));
                }
            }
        }
    }
}
