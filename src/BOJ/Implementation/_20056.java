package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _20056 {
    static int n, k;

    static Queue<Node>[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = new LinkedList<>();
            }
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            list[x][y].add(new Node(mass, speed, dir, 1));
        }

        solve(1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (!list[i][j].isEmpty()) {
                    res += list[i][j].poll().mass;
                }
            }
        }

        System.out.println(res);
    }

    private static void solve(int count) {
        if (count > k) return;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (!list[i][j].isEmpty() && list[i][j].peek().cnt == count) {
                    int x = i;
                    int y = j;
                    Node cur = list[i][j].poll();
                    int dir = cur.dir;
                    int speed = cur.speed;
                    int mass = cur.mass;

                    for (int l = 0; l < speed; l++) {
                        x += dx[dir];
                        y += dy[dir];
                        if (x == -1) x = n - 1;
                        if (y == -1) y = n - 1;
                        if (x == n) x = 0;
                        if (y == n) y = 0;
                    }
                    list[x][y].add(new Node(mass, speed, dir, count + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list[i][j].size() <= 1) continue;
                int mod = list[i][j].peek().dir % 2;
                boolean isOk = true;
                int massSum = 0;
                int speedSum = 0;
                int size = 0;

                while (!list[i][j].isEmpty()) {
                    Node node = list[i][j].poll();
                    massSum += node.mass;
                    speedSum += node.speed;
                    size++;
                    if (node.dir % 2 != mod) isOk = false;
                }
                if (massSum / 5 == 0) continue;

                for (int l = 0; l < 4; l++) {
                    int mass = massSum / 5;
                    int speed = speedSum / size;
                    int dir = isOk ? sameModDir[l] : difModDir[l];
                    list[i][j].add(new Node(mass, speed, dir, count + 1));
                }
            }
        }
        solve(count + 1);
    }

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] sameModDir = {0, 2, 4, 6};
    static int[] difModDir = {1, 3, 5, 7};

    static class Node {
        int mass;
        int speed;
        int dir;
        int cnt;

        public Node(int mass, int speed, int dir, int cnt) {
            this.mass = mass;
            this.speed = speed;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
