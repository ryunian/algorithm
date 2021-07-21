package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17142 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, k, virusCnt = 0, res = Integer.MAX_VALUE;
    static boolean[] active;
    static int[][] map;
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if (x == 0) virusCnt++;
                if (x == 2) {
                    list.add(new Node(i, j));
                }
            }
        }

        active = new boolean[list.size()];
        if(virusCnt == 0){
            System.out.println(0);
        }else{
            solve(0, 0);
            System.out.println(res == Integer.MAX_VALUE ? -1 : res-1);
        }
    }

    private static void solve(int idx, int cnt) {
        if (cnt == k) {
            bfs();
            return;
        }
        for (int i = idx; i < list.size(); i++) {
            if (!active[i]) {
                active[i] = true;
                solve(i, cnt + 1);
                active[i] = false;
            }
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int[][] visit = new int[n][n];
        for (int i = 0; i < active.length; i++) {
            if (active[i]) {
                queue.add(list.get(i));
                visit[list.get(i).x][list.get(i).y] = 1;
            }
        }
        int cnt = 0;
        int time = 0;
        boolean isPossible = false;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cnt == virusCnt && map[cur.x][cur.y] == 0){
                isPossible = true;
                time = Math.max(time, visit[cur.x][cur.y]);
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if(visit[nx][ny] == 0 && map[nx][ny] != 1 && map[cur.x][cur.y] < res){
                    if(map[nx][ny] == 0) cnt++;
                    visit[nx][ny] = visit[cur.x][cur.y] +1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        if(isPossible){
            res = Math.min(res, time);
        }
    }
}
