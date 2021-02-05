package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2146 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, res = Integer.MAX_VALUE;
    static int[][] map, visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int flag = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 0 && map[i][j] == 1) {
                    bfs(i, j, flag++);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    solve(i, j);
                }
            }
        }
        System.out.println(res - 1);

    }

    private static void solve(int x, int y) {
        // 섬의 가장자리인지 체크
        boolean finish = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if (map[nx][ny] == 0) {
                finish = false;
                break;
            }
        }
        if (finish) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int[][] check = new int[n][n];
        check[x][y] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                // 바다를 건넌다.
                if (check[nx][ny] == 0 && map[nx][ny] == 0 && check[cur.x][cur.y] < res) {
                    check[nx][ny] = check[cur.x][cur.y] + 1;
                    queue.add(new Node(nx, ny));
                }
                // 서로 다른 섬을 만날 경우 최소길이 저장
                else if (map[nx][ny] != 0 && map[nx][ny] != map[x][y]) {
                    res = Math.min(res, check[cur.x][cur.y]);
                }
            }
        }
    }


    // 각각의 섬을 구분한다
    private static void bfs(int x, int y, int flag) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = 1;
        map[x][y] = flag;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (visit[nx][ny] == 0 && map[nx][ny] == 1) {
                    visit[nx][ny] = 1;
                    queue.add(new Node(nx, ny));
                    map[nx][ny] = flag;
                }
            }
        }

    }
}
