package BOJ.Graph.MST.Prim;

import java.io.*;
import java.util.*;

// 도시 분할 계획
public class _1647_PRIM {
    static int n, m, cnt, sum, max;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        prim();
        System.out.println(sum - max);
    }

    private static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        boolean[] visit = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.vertex]) continue;
            visit[cur.vertex] = true;

            sum += cur.cost;
            max = Math.max(max, cur.cost);
            for (Node next : list[cur.vertex]) {
                if (visit[next.vertex]) continue;
                pq.add(next);
            }
            if (++cnt == n) return;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
