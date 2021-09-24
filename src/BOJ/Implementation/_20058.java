package BOJ.Implementation;

import java.io.*;
import java.util.*;

// 마법사 상어와 파이어스톰
public class _20058 {
    static int q, n;
    static int[][] arr, tmp;
    static boolean[][] visit;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = 1 << Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visit = new boolean[n][n];
        tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (q-- > 0) {
            int query = 1 << Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i += query) {
                for (int j = 0; j < n; j += query) {
                    rotate(i, j, query);
                }
            }
            melt();
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
                if (visit[i][j] || arr[i][j] == 0) continue;
                max = Math.max(max, bfs(i, j));
            }
        }
        System.out.println(sum);
        System.out.println(max);
    }

    private static void melt() {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                int ice = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (arr[nx][ny] > 0) ice++;
                }
                if (ice < 3) {
                    list.add(new Node(i, j));
                }
            }
        }
        for (Node node : list) {
            arr[node.x][node.y]--;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;

        int ret = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visit[nx][ny] || arr[nx][ny] == 0) continue;
                visit[nx][ny] = true;
                queue.add(new Node(nx, ny));
                ret++;
            }
        }
        return ret;
    }

    private static void rotate(int y, int x, int query) {
        for (int i = y; i < y + query; i++) {
            for (int j = x; j < x + query; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        for (int i = y; i < y + query; i++) {
            for (int j = x; j < x + query; j++) {
                arr[j - x + y][x + y + query - i - 1] = tmp[i][j];
            }
        }
    }
}
