package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3055 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean finish;
    static int n, m, startX, startY, endX, endY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static Queue<Node> water = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < m; j++) {
                char y = x.charAt(j);
                map[i][j] = y;
                if (y == 'D') {
                    endX = i;
                    endY = j;
                } else if (y == 'S') {
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                } else if (y == '*') {
                    water.add(new Node(i, j));
                }
            }
        }

        solve();
    }

    private static void solve() {
        int[][] visit = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visit[startX][startY] = 1;

        int cnt = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 고슴도치가 비버굴을 방문
            if (cur.x == endX && cur.y == endY) {
                cnt = visit[cur.x][cur.y];
                finish = true;
                break;
            }
            if (cnt < visit[cur.x][cur.y]) {
                // 물이 찬다.
                spread();
                cnt = visit[cur.x][cur.y];
            }

            // 고슴도치가 움직인다
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (visit[nx][ny] == 0 && (map[nx][ny] == 'D' || map[nx][ny] == '.')) {
                    visit[nx][ny] = visit[cur.x][cur.y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        System.out.println(finish ? cnt - 1 : "KAKTUS");
    }

    private static void spread() {
        Queue<Node> tmp = new LinkedList<>();
        while (!water.isEmpty()) {
            Node cur = water.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == '.') {
                    map[nx][ny] = '*';
                    tmp.add(new Node(nx, ny));
                }
            }
        }
        water = tmp;
    }
}
