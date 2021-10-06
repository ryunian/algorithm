package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 줄기세포배양
public class _5653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[1000][1000];
            PriorityQueue<Node> pq = new PriorityQueue<>();

            for (int i = 500; i < n + 500; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 500; j < m + 500; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 0) continue;
                    Node node = new Node(i, j, tmp, tmp + 1);
                    pq.add(node);
                    arr[i][j] = tmp * 2;
                }
            }
            int time = 1;
            while (time <= k) {
                while (!pq.isEmpty() && pq.peek().time == time) {
                    Node cur = pq.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];
                        if (arr[nx][ny] != 0) continue;
                        Node node = new Node(nx, ny, cur.life, time + cur.life + 1);
                        arr[nx][ny] = time + cur.life * 2;
                        pq.add(node);
                    }
                }
                time++;
            }
            int res = 0;
            for (int[] a : arr) {
                for (int b : a) {
                    if (b >= time) res++;
                }
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node implements Comparable<Node> {
        int x, y, life, time;

        public Node(int x, int y, int life, int time) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (time == o.time) return o.life - life;
            return time - o.time;
        }
    }
}
