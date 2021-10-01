package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 무선 충전
public class _5644 {
    static int m;
    static int[][][] arr;
    static int[] userA, userB;
    // 상 우 하 좌
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            arr = new int[10][10][m];
            userA = new int[m];
            userB = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                userA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                userB[i] = Integer.parseInt(st.nextToken());
            }

            int idx = 0;
            while (a-- > 0) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bfs(x, y, c, p, idx++);
            }
            System.out.printf("#%d %d\n", tc, move(m));
        }
    }

    private static int move(int m) {
        int x1 = 0, y1 = 0;
        int x2 = 9, y2 = 9;
        int sum = charge(x1, y1, x2, y2);

        for (int i = 0; i < m; i++) {
            x1 += dx[userA[i]];
            y1 += dy[userA[i]];
            x2 += dx[userB[i]];
            y2 += dy[userB[i]];
            sum += charge(x1, y1, x2, y2);
        }
        return sum;
    }

    private static int charge(int x1, int y1, int x2, int y2) {
        ArrayList<Pair> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (arr[x1][y1][i] != 0) tmp.add(new Pair(0, i, arr[x1][y1][i]));
            if (arr[x2][y2][i] != 0) tmp.add(new Pair(1, i, arr[x2][y2][i]));
        }
        tmp.sort(null);
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            for (Pair pair : tmp) {
                if (pair.user != i || set.contains(pair.idx)) continue;
                sum += pair.val;
                set.add(pair.idx);
                break;
            }
        }
        int sum2 = 0;
        set = new HashSet<>();
        for (int i = 1; i >= 0; i--) {
            for (Pair pair : tmp) {
                if (pair.user != i || set.contains(pair.idx)) continue;
                sum2 += pair.val;
                set.add(pair.idx);
                break;
            }
        }
        return Math.max(sum, sum2);
    }

    private static void bfs(int x, int y, int c, int p, int idx) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        arr[x][y][idx] = p;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 1; i <= 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nc = cur.c + 1;
                if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;
                if (arr[nx][ny][idx] != 0 || nc > c) continue;
                arr[nx][ny][idx] = p;
                queue.add(new Node(nx, ny, nc));
            }
        }
    }

    static class Node {
        int x, y, c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static class Pair implements Comparable<Pair> {
        int user, idx, val;

        public Pair(int user, int idx, int val) {
            this.user = user;
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - val;
        }
    }
}
