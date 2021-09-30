package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 보급로
public class _1249 {
    static int n, INF = 987654321;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            sb.append(String.format("#%d %d\n", tc, solve()));
        }
        System.out.print(sb.toString());
    }

    private static int solve() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));

        int[][] visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], INF);
        }
        visit[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == n - 1 && cur.y == n - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int ncost = cur.cost + (arr[nx][ny] - '0');
                if (visit[nx][ny] > ncost) {
                    visit[nx][ny] = ncost;
                    queue.add(new Node(nx, ny, ncost));
                }
            }
        }
        return visit[n - 1][n - 1];
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
