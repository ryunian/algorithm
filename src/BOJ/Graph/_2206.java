package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2206 {
    static int[][] map;
    static int n, m, result = Integer.MAX_VALUE;
    static boolean[][][] visited;
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = x.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(a, b, 0, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int destroy = node.destroy;
            int dis = node.distance;

            if (x == n - 1 && y == m - 1) {
                result = Math.min(dis, result);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 1 : 벽을 부숨 , 0: 벽을 안부숨
                // 벽을 이미 부숨
                if (destroy == 1) {
                    if (!visited[nx][ny][destroy] && map[nx][ny] == 0) {
                        visited[nx][ny][destroy] = true;
                        queue.add(new Node(nx, ny, destroy, dis + 1));
                    }
                } else { // 벽을 부술 수 있음
                    // 부수고 감
                    if (!visited[nx][ny][destroy + 1] && map[nx][ny] == 1) {
                        visited[nx][ny][destroy + 1] = true;
                        queue.add(new Node(nx, ny, destroy + 1, dis + 1));

                        // 안부수고 감
                    } else if (!visited[nx][ny][destroy] && map[nx][ny] == 0) {
                        visited[nx][ny][destroy] = true;
                        queue.add(new Node(nx, ny, destroy, dis + 1));
                    }

                }
            }
        }
    }

    private static class Node {
        int x;
        int y;
        int destroy;
        int distance;

        public Node(int x, int y, int destroy, int distance) {
            this.x = x;
            this.y = y;
            this.destroy = destroy;
            this.distance = distance;
        }
    }
}

