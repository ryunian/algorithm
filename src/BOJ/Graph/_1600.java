package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600 {
    private static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int k, n, m;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {1, -1, 0, 0, -2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dz = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] a : map){
            for(int b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }

        solve();
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        int[][][] visit = new int[n][m][k+1];
        visit[0][0][0] = 1;

        int res = -1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int z = cur.z;
            if (x == n - 1 && y == m - 1) {
                res = visit[x][y][z] -1;
                break;
            }

            for (int i = 0; i < 12; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || nz > k) continue;
                if (map[nx][ny] == 0 && visit[nx][ny][nz] == 0) {
                    visit[nx][ny][nz] = visit[x][y][z] + 1;
                    queue.add(new Node(nx, ny, nz));
                }
            }
        }
        System.out.println(res);
    }
}
