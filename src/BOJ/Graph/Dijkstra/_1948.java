package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라, 가장 먼곳에 있는 노드 검색 및 역추적 문제
public class _1948 {
    private static int n, m, start, end, INF = 987654321;
    private static int[] visit;
    private static ArrayList<Node>[] list;
    private static ArrayList<Integer>[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        solve();
    }

    private static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.cost-o1.cost);
        pq.add(new Node(start, 0));

        visit = new int[n + 1];
        prev = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            prev[i] = new ArrayList<>();
        }

        Arrays.fill(visit, 0);
        visit[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : list[cur.vertex]) {
                int nextCost = cur.cost + next.cost;
                if (visit[next.vertex] < nextCost) {
                    visit[next.vertex] = nextCost;
                    prev[next.vertex].clear();
                    prev[next.vertex].add(cur.vertex);
                    pq.add(new Node(next.vertex, nextCost));
                } else if(visit[next.vertex] == nextCost) {
                    prev[next.vertex].add(cur.vertex);
                }
            }
        }

        System.out.println(visit[end]);
        visit = new int[n+1];
        find(n);
        System.out.println(res);
    }

    private static int res = 0;
    private static void find(int idx) {
        if(idx <= 1) return;
        if(visit[idx] != 0) return;

        visit[idx] = 1;
        for (int i = 0; i < prev[idx].size(); i++) {
            res++;
            int next = prev[idx].get(i);
            find(next);
        }
    }

    private static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
