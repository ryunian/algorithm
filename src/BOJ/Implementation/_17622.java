package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17622 {
    private static int n, k;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 9);
        }
        map[0][0] = map[n - 1][n + 1] = 5;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
            }
        }
        startX = 0;
        startY = 0;
        endX = n - 1;
        endY = n + 1;

        if (k == 0) {
            int res = solve();
            System.out.println(res);
        } else {
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    int tmp = map[i][j];
                    for (int l = 0; l < 6; l++) {
                        if(tmp == l) continue;
                        map[i][j] = l;
                        int val = solve();
                        if(val != -1){
                            res = Math.min(res, val);
                        }
                    }
                    map[i][j] = tmp;
                }
            }
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);
        }
    }

    private static int[][] moveX = {{0, 1}, {0, 1}, {-1, 0}, {-1, 0}, {-1, 1}, {0, 0}};
    private static int[][] moveY = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {0, 0}, {-1, 1}};
    static int startX, startY, endX, endY;

    private static int solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 1));
        boolean[][] visit = new boolean[n][n + 2];
        visit[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == endX && cur.y == endY) {
                return cur.num - 2;
            }

            int tile = map[cur.x][cur.y];
            for (int i = 0; i < 2; i++) {
                int nx = cur.x + moveX[tile][i];
                int ny = cur.y + moveY[tile][i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n + 2) continue;
                if (map[nx][ny] == 9) continue;

                if (!visit[nx][ny] && check(cur.x, cur.y, nx, ny)) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny, cur.num + 1));
                }
            }
        }
        return -1;
    }

    private static boolean check(int prevX, int prevY, int nextX, int nextY) {
        int tile = map[nextX][nextY];
        if (tile < 0 || 6 <= tile) return false;
        for (int i = 0; i < 2; i++) {
            int x = nextX + moveX[tile][i];
            int y = nextY + moveY[tile][i];

            if (x == prevX && y == prevY) {
                return true;
            }
        }
        return false;
    }


    private static class Node {
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

    }

    private static void print(int[][] map) {
        System.out.println();
        for (int[] a : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
