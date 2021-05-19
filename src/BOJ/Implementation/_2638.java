package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2638 {
    private static int n,m,size = 0;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
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
                if (x == 1) {
                    size++;
                }
            }
        }
        int res = 0;
        while (size > 0) {
            size -= solve();
            res++;
        }
        System.out.println(res);
    }

    private static int solve() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        int[][] visit = new int[n][m];
        visit[0][0] = -1;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny] == -1) continue;

                if(map[nx][ny] == 1){
                    visit[nx][ny]++;
                }else {
                    visit[nx][ny] = -1;
                    queue.add(new Pair(nx, ny));
                }
            }
        }


        return delete(visit);
    }

    private static int delete(int[][] visit) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] >= 2){
                    ret++;
                    map[i][j] = 0;
                }
            }
        }
        return ret;
    }


    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print(int[][] visit){
        for(int[] a : visit){
            for(int b : a){
                System.out.print(b+1+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
