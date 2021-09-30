package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 탈주범 검거
public class _1953 {
    static int n, m, sx, sy, time;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static HashMap<Integer, Integer> mapping;

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(String.format("#%d %d\n", tc, solve()));
        }
        System.out.print(sb.toString());
    }

    private static int solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy, 0));

        boolean[][] visit = new boolean[n][m];
        visit[sx][sy] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cnt++;
            int type = arr[cur.x][cur.y];

            for (int i = 0; i < 4; i++) {
                int bit = 1 << (3 - i);
                if ((bit & mapping.get(type)) == 0) continue;
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nt = cur.t + 1;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny] || arr[nx][ny] == 0 || nt >= time) continue;
                int j = i + (i % 2 == 0 ? 1 : -1);
                int rbit = 1 << (3 - j);
                if ((rbit & mapping.get(arr[nx][ny])) == 0) continue;

                visit[nx][ny] = true;
                queue.add(new Node(nx, ny, nt));
            }
        }
        return cnt;
    }

    static class Node {
        int x, y, t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static void init() {
        mapping = new HashMap<>();
        mapping.put(1, 15); // 1111
        mapping.put(2, 12); // 1100
        mapping.put(3, 3);  // 0011
        mapping.put(4, 9);  // 1001
        mapping.put(5, 5);  // 0101
        mapping.put(6, 6);  // 0110
        mapping.put(7, 10); // 1010
    }
}
