package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다리 만들기 2
public class _17472 {
    static int n, m, res;
    static int[] num;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || map[i][j] != 1) continue;
                making(i, j, ++cnt);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                addToList(i, j, map[i][j]);
            }
        }
        kruskal(cnt);
    }

    private static void addToList(int i, int j, int type) {
        for (int k = 0; k < 2; k++) {
            int x = i;
            int y = j;
            int cnt = 0;
            while (true) {
                x += dx[k];
                y += dy[k];
                if (x >= n || y >= m || map[x][y] == type) break;
                if (map[x][y] != 0) {
                    if (cnt >= 2) {
                        list.add(new Node(type, map[x][y], cnt));
                    }
                    break;
                }
                cnt++;
            }
        }
    }

    private static void making(int x, int y, int cnt) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;
        map[x][y] = cnt;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny] || map[nx][ny] != 1) continue;
                visit[nx][ny] = true;
                map[nx][ny] = cnt;
                queue.add(new Node(nx, ny));
            }
        }
    }

    private static void kruskal(int size) {
        // lambda
        list.sort(Comparator.comparingInt(o -> o.cost));

        // only lambda
        list.sort((o1, o2) -> o1.cost - o2.cost);

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        num = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            num[i] = i;
        }
        int cnt = 1;
        for (Node node : list) {
            cnt += union(node);
        }
        System.out.println(cnt == size - 1 ? res : -1);
    }

    private static int union(Node node) {
        int a = find(node.x);
        int b = find(node.y);

        if (a != b) {
            num[a] = b;
            res += node.cost;
            return 1;
        }
        return 0;
    }

    private static int find(int x) {
        if (num[x] == x) return x;
        return num[x] = find(num[x]);
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
