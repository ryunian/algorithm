package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2573 {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean finish;
    static int n, m;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;

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
            }
        }

        int year = 1;
        while (true) {
//            System.out.println("year = "+year);
            // 빙산을 녹인다.
            meltIce();

//            for(int[] a : map){
//                for(int b : a){
//                    System.out.print(b+" ");
//                }
//                System.out.println();
//            }


            // 두덩이인지 체크
            visit = new boolean[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] != 0 && !visit[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            // 2개 이상으로 분리되어있는지 체크
            if(cnt > 1){
                System.out.println(year);
                break;
            }

            if(finish){
                System.out.println(0);
                break;
            }
            year++;
        }
    }

    // 빙산을 녹인다
    private static void meltIce() {
        int[][] tmp = new int[n][m];
        boolean allMelt = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                allMelt = false;
                int waterCnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(map[nx][ny] == 0){
                        waterCnt++;
                    }
                }
                int val = map[i][j] - waterCnt;
                if (val > 0) tmp[i][j] = val;
            }
        }
        map = tmp;
        if(allMelt){
            finish = true;
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visit[x][y] = true;

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visit[nx][ny] && map[nx][ny] > 0){
                    visit[nx][ny]= true;
                    queue.add(new Node(nx,ny));
                }
            }
        }
    }
}
