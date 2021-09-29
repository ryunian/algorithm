package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17141 {
    static int n, m, cnt, res = Integer.MAX_VALUE;
    static List<Node> list;
    static int[] chk;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;

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
        list = new ArrayList<>();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if (tmp != 1) {
                    cnt++;
                }
                if (tmp == 2) {
                    list.add(new Node(i, j));
                }
            }
        }
        chk = new int[m];
        solve(0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void solve(int idx, int num) {
        if (num == m) {
            bfs();
            return;
        }
        if (idx == list.size()) return;
        chk[num] = idx;
        solve(idx + 1, num + 1);
        solve(idx + 1, num);

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int[][] visit = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = list.get(chk[i]).x;
            int y = list.get(chk[i]).y;
            queue.add(new Node(x, y));
            visit[x][y] = 1;
        }

        int max = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int time = visit[cur.x][cur.y];
            max = Math.max(max, time - 1);
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (arr[nx][ny] == 1 || visit[nx][ny] != 0) continue;
                visit[nx][ny] = time + 1;
                queue.add(new Node(nx, ny));
            }
        }
        if (count == cnt) {
            res = Math.min(res, max);
        }
    }
}
