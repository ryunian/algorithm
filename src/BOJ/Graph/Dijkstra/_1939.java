package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 중량제한
public class _1939 {
    static int n, m, start, end, INF = Integer.MAX_VALUE;
    static List<Edge>[] list;

    static class Edge {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        solve();
    }

    private static void solve() {
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
        queue.add(new Edge(start, INF));

        int[] visit = new int[n + 1];
        Arrays.fill(visit, INF * -1);
        visit[start] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            if (cur.vertex == end) {
                System.out.println(cur.cost);
                break;
            }

            for (Edge next : list[cur.vertex]) {
                int nCost = Math.min(cur.cost, next.cost);

                if (visit[next.vertex] < nCost) {
                    visit[next.vertex] = nCost;
                    queue.add(new Edge(next.vertex, nCost));
                }
            }
        }
    }
}
