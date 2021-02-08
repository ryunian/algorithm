package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5427 {
    static int n, m, startX, startY;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new char[n][m];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    char x = str.charAt(j);
                    map[i][j] = x;
                    if (x == '@') {
                        map[i][j] = '.';
                        startX = i;
                        startY = j;
                    } else if (x == '*') {
                        list.add(new Node(i, j));
                    }
                }
            }
            solve();
        }
    }

    private static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));

        boolean[][] visit = new boolean[n][m];
        visit[startX][startY] = true;

        int sec = -1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (sec < cur.time) {
                sec = cur.time;
                // 불이번진다.
                burn();
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    System.out.println(cur.time+1);
                    return;
                }
                if (!visit[nx][ny] && map[nx][ny] == '.') {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny, cur.time + 1));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void burn() {
        ArrayList<Node> tmp = new ArrayList<>();
        for (Node cur : list) {
            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == '.'){
                    map[nx][ny] = '*';
                    tmp.add(new Node(nx, ny));
                }
            }
        }
        list = tmp;
    }
}
