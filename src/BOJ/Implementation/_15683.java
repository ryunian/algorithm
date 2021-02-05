package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15683 {
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

    static int n, m, res = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Node> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if (0 < x && x < 6) {
                    list.add(new Node(i, j, x));
                }
            }
        }
        solve(0, map);
        System.out.println(res);
    }

    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void solve(int idx, int[][] map) {
        if (idx == list.size()) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) cnt++;
                }
            }
            res = Math.min(res, cnt);
            return;
        }
        Node cur = list.get(idx);

        for (int i = 0; i < 4; i++) {
            int[][] newmap = copy(map);
            if (cur.num == 1) {
                fill(cur, i, newmap);
            } else if (cur.num == 2) {
                if (i >= 2) continue;
                fill(cur, i, newmap);
                fill(cur, (i + 2) % 4, newmap);
            } else if (cur.num == 3) {
                fill(cur, i % 4, newmap);
                fill(cur, (i + 1) % 4, newmap);
            } else if (cur.num == 4) {
                fill(cur, i % 4, newmap);
                fill(cur, (i + 1) % 4, newmap);
                fill(cur, (i + 2) % 4, newmap);
            } else if (cur.num == 5) {
                if (i != 0) continue;
                fill(cur, 0, newmap);
                fill(cur, 1, newmap);
                fill(cur, 2, newmap);
                fill(cur, 3, newmap);
            }
            solve(idx + 1, newmap);

        }
    }

    private static int[][] copy(int[][] map) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    private static void fill(Node node, int dir, int[][] map) {
        int nx = node.x;
        int ny = node.y;
        while (true) {
            nx += dx[dir];
            ny += dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6) {
                break;
            }
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
            }
        }
    }
}
