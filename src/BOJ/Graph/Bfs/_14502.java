package BOJ.Graph.Bfs;

import java.io.*;
import java.util.*;

// 연구소
public class _14502 {
    static int n, m, safeCnt, res, cnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map, visit;
    static Queue<Node> virus;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];
        virus = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int state = Integer.parseInt(st.nextToken());
                map[i][j] = state;
                if (state == 2) {
                    virus.add(new Node(i, j));
                } else if (state == 0) {
                    safeCnt++;
                }
            }
        }

        solve(0, 0);
        System.out.println(res);
    }

    private static void solve(int num, int wall) {
        if (wall == 3) {
            bfs(++cnt);
            return;
        }

        for (int i = num; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            if (map[x][y] == 0) {
                map[x][y] = 1;
                solve(i, wall + 1);
                map[x][y] = 0;
            }
        }
    }

    private static void bfs(int flag) {
        Queue<Node> queue = new LinkedList<>();
        queue.addAll(virus);

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] != 0 || visit[nx][ny] == flag) continue;
                cnt++;
                visit[nx][ny] = flag;
                queue.add(new Node(nx, ny));
            }
        }
        res = Math.max(res, safeCnt - cnt - 3);
    }
}
