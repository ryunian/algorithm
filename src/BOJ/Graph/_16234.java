package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean finish;
    static int n, l, r, res = 0;
    static boolean[][] visit;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();

        System.out.println(res);
    }

    private static void solve() {
        finish = false;
        visit = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j]){
                    bfs(i, j);
                }
            }
        }

        if(finish){
            res++;
            solve();
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        visit[x][y] = true;
        int sum = map[x][y];
        ArrayList<Node> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            list.add(cur);

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int dis = Math.abs(map[nx][ny] - map[cur.x][cur.y]);
                if (!visit[nx][ny] && l <= dis && dis <= r) {
                    sum += map[nx][ny];
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        if (list.size() == 1) {
            return;
        }

        for(Node node : list){
            map[node.x][node.y] = sum / list.size();
        }

        finish = true;
    }
}
