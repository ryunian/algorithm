package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2589 {
    static int row, col, res = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != 'W') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(res);
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        int[][] visit = new int[row][col];
        visit[i][j] = 1;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            res = Math.max(res, visit[cur.x][cur.y] - 1);
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (visit[nx][ny] != 0 || map[nx][ny] == 'W') continue;

                queue.add(new Pair(nx, ny));
                visit[nx][ny] = visit[cur.x][cur.y] + 1;
            }
        }
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
