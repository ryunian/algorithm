package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2583 {
    private static int n, m, k;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int a = x1; a < x2; a++) {
                for (int b = y1; b < y2; b++) {
                    map[a][b] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 && visit[i][j] == 0){
                    list.add(solve(i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) +" ");
        }

        System.out.println(list.size());
        System.out.println(sb.toString());
    }

    private static int solve(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visit[x][y] = 1;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny] == 0 && map[nx][ny] == 0){
                    visit[nx][ny] =1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
        return cnt;
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
