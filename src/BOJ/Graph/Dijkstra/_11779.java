package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소비용 구하기 2
public class _11779 {
    static int n, INF = 987654321;
    static List<Edge>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        solve(a, b);
    }

    private static void solve(int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Edge(start, 0));

        int[][] visit = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(visit[i], INF);
        }
        visit[start][0] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            if (cur.vertex == end) {
                break;
            }

            for (Edge next : list[cur.vertex]) {
                int tmp = visit[cur.vertex][0] + next.cost;

                if (visit[next.vertex][0] > tmp) {
                    visit[next.vertex][0] = tmp;
                    visit[next.vertex][1] = cur.vertex;
                    queue.add(new Edge(next.vertex, tmp));
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (stack.peek() != start){
            stack.push(visit[stack.peek()][1]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(visit[end][0]).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }

    static class Edge {
        int vertex, cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
