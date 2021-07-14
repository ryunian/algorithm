package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194 {
    private static int x, y, startX, startY;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new char[x][y];
        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                char tmp = str.charAt(j);
                if (tmp == '0') {
                    startX = i;
                    startY = j;
                }
                arr[i][j] = tmp;
            }
        }


        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));

        // A~F 의 키를 전부 소유했을 경우 63
        int[][][] visit = new int[x][y][64];
        visit[startX][startY][0] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (arr[cur.x][cur.y] == '1') {
                System.out.println(visit[cur.x][cur.y][cur.key] - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int key = cur.key;

                if (nx < 0 || ny < 0 || nx >= x || ny >= y) continue;

                char tmp = arr[nx][ny];

                if (arr[nx][ny] == '#') continue;
                if ('A' <= tmp && tmp <= 'F') {
                    int bit = toBit(tmp);
                    if (bit != (bit & key)) continue;
                }

                if ('a' <= tmp && tmp <= 'f') {
                    key = key | toBit(tmp);
                }

                if (visit[nx][ny][key] == 0) {
                    visit[nx][ny][key] = visit[cur.x][cur.y][cur.key] + 1;
                    queue.add(new Node(nx, ny, key));
                }
            }
        }

        System.out.println(-1);
    }

    private static class Node {
        int x;
        int y;
        int key;

        public Node(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }

    }

    private static int toBit(char ch) {
        return 1 << (ch - 'a');
    }
}