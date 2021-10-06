package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 줄기세포배양
public class _5653_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            Set<Node> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp == 0) continue;
                    Node node = new Node(i, j, tmp, tmp + 1);
                    pq.add(node);
                    set.add(node);
                }
            }

            int time = 1;
            while (time <= k) {
                while (!pq.isEmpty() && pq.peek().time == time) {
                    Node cur = pq.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];
                        Node node = new Node(nx, ny, cur.life, time + cur.life + 1);
                        if (set.contains(node)) continue;
                        pq.add(node);
                        set.add(node);
                    }
                }
                time++;
            }
            int cnt = 0;
            for (Node node : set) {
                if (node.time -1 + node.life >= time) cnt++;
            }
            System.out.printf("#%d %d\n", tc, cnt);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        // contains 가 제대로 중복 확인을 안해줘서 31 대신 101531 이라는 소수를 사용
        @Override
        public int hashCode() {
            final int prime = 101531;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
    }
}
