package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16236 {
    private static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCnt() {
            return cnt;
        }
    }

    static int n, startX, startY, res = 0;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        solve(startX, startY, 0, 2);
    }

    private static void solve(int x, int y, int eat, int size) {
        if (!eatPosible(size)) {
            System.out.println(res);
            return;
        }

        bfs(x, y, eat, size);
    }

    private static void bfs(int x, int y, int eat, int size) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));

        boolean[][] visit = new boolean[n][n];
        visit[x][y] = true;

        // 먹을 수 있는 물고기의 정보를 담는 임시 리스트
        ArrayList<Node> tmp = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (visit[nx][ny] == false && map[nx][ny] <= size) {
                    if (map[nx][ny] != 0 && map[nx][ny] < size) {
                        tmp.add(new Node(nx, ny, cur.cnt + 1));
                        visit[nx][ny] = visit[cur.x][cur.y];
                    } else {
                        queue.add(new Node(nx, ny, cur.cnt + 1));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        // 먹을 물고기가 있지만 그 물고기에 가지 못할떄
        if (tmp.size() == 0) {
            System.out.println(res);
            return;
        }
        // 거리가 가장 짧으면서 가장 위에 있으며, 가장 왼쪽에 있는 것 기준으로 정렬
        tmp.sort(Comparator.comparing(Node::getCnt).thenComparing(Node::getX).thenComparing(Node::getY));
        Node ret = tmp.get(0);
        // size 만큼 먹었다면 성장한다.
        if (++eat == size) {
            eat = 0;
            size++;
        }

        map[ret.x][ret.y] = 0;
        res += ret.cnt;

        solve(ret.x, ret.y, eat, size);
    }

    private static boolean eatPosible(int size) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0 && map[i][j] < size) {
                    return true;
                }
            }
        }
        return false;
    }
}