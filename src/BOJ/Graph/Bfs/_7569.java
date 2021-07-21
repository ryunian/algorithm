package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569 {
    private static class Node {
        int x;
        int y;
        int h;

        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int n, m, h, unripeCnt = 0;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[][][] map;
    static ArrayList<Node> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int x = Integer.parseInt(st.nextToken());
                    map[j][k][i] = x;
                    if (x == 1) list.add(new Node(j, k, i));
                    if (x == 0) unripeCnt++;
                }
            }
        }

        solve();
    }

    private static void solve() {
        if (unripeCnt == 0) {
            System.out.println(0);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        int[][][] visit = new int[n][m][h];
        for (Node node : list) {
            queue.add(node);
            visit[node.x][node.y][node.h] = 1;
        }

        int day = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (unripeCnt == 0) {
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                int nh = dh[i] + cur.h;
                if (nx < 0 || ny < 0 || nh < 0 || nx >= n || ny >= m || nh >= h) continue;

                // 다음에 방문한 곳이 방문하지 않고, 익지않은 토마토일 경우
                if (visit[nx][ny][nh] == 0 && map[nx][ny][nh] == 0) {
                    // 방문한 날짜
                    visit[nx][ny][nh] = visit[cur.x][cur.y][cur.h] + 1;
                    // 날짜의 최대값
                    day = Math.max(day, visit[nx][ny][nh]);
                    queue.add(new Node(nx, ny, nh));
                    // 익지않은 토마토의 수 -1
                    unripeCnt--;
                }
            }
        }
        System.out.println(unripeCnt == 0 ? day - 1 : -1);
    }
}
