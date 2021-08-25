package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 하나로 kruskal version
public class _1251_2 {
    static int n;
    static int[][] pair;
    static double E;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            pair = new int[n][2];

            list = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                list[i] = new LinkedList<>();
            }

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    pair[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            E = Double.parseDouble(br.readLine());

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    long x = Math.abs(pair[i][0] - pair[j][0]);
                    long y = Math.abs(pair[i][1] - pair[j][1]);
                    long cost = x * x + y * y;
                    list[i].add(new Node(j, cost));
                    list[j].add(new Node(i, cost));
                }
            }
            long res = prim();
            sb.append(String.format("#%d %d\n", tc, Math.round(res * E)));
        }
        System.out.print(sb);
    }

    // PRIM
    private static long prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        pq.add(new Node(0, 0));
        boolean[] visit = new boolean[n];

        long ret = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur.vertex]) continue;
            visit[cur.vertex] = true;
            ret += cur.cost;

            for (Node next : list[cur.vertex]) {
                if (visit[next.vertex]) continue;
                pq.add(next);
            }
            if (++cnt == n) break;
        }
        return ret;

    }

    static class Node {
        int vertex;
        long cost;

        public Node(int vertex, long cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
