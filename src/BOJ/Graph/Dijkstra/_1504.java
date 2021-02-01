package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1504 {
    private static class Edge {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static int n, m, v1, v2;
    // 간선의 최대 값 * 거리의 최대값 = 200000000
    // 최악의 경우 INF * 3는 int 범위내에 있다
    static int INF = 200000001;
    static ArrayList<Edge>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 무방향 그래프
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int a = solve(1, v1) + solve(v1, v2) + solve(v2, n);
        int b = solve(1, v2) + solve(v2, v1) + solve(v1, n);
        int res = Math.min(a, b);
        System.out.println(res >= INF ? -1 : res);
    }

    private static int solve(int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        queue.add(new Edge(start, 0));
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            if (cur.vertex == end) {
                break;
            }

            for (Edge next : list[cur.vertex]) {
                if (cost[next.vertex] > cost[cur.vertex] + next.cost) {
                    cost[next.vertex] = cost[cur.vertex] + next.cost;
                    queue.add(new Edge(next.vertex, cost[next.vertex]));
                }
            }
        }
        return cost[end];
    }
}
