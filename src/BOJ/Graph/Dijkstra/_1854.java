package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 의 K번째 최단경로 문제
// 최소거리를 담는 배열대신 우선순위큐 (maxHeap) 리스트에 담는다.
// 새로운 값이 우선순위 큐의 가장 큰값으보다 작을경우 현재값을 삭제하고 대신 넣으면서 구현
public class _1854 {
    private static int v, e, k;
    private static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 인접리스트
        list = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }

        solve();
    }

    private static void solve() {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        queue.add(new Node(1, 0));
        PriorityQueue<Integer>[] dp = new PriorityQueue[v + 1];
        for (int i = 0; i <= v; i++) {
            dp[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        dp[1].add(0);

        // 다익스트라 start
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node next : list[cur.vertex]) {
                int val = cur.cost + next.cost;

                // 다음 정점의 dp pq 의 사이즈가 k 보다 적으면 바로 삽입
                if (dp[next.vertex].size() < k) {
                    dp[next.vertex].add(val);
                    queue.add(new Node(next.vertex, val));

                } else {
                    // 요소의 최대값보다 들어갈 값이 더 작을 경우
                    if (dp[next.vertex].peek() > val) {
                        dp[next.vertex].poll();
                        dp[next.vertex].add(val);
                        queue.add(new Node(next.vertex, val));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dp[i].size() < k) {
                sb.append(-1 + "\n");
            } else {
                sb.append(dp[i].peek() + "\n");
            }
        }
        System.out.print(sb.toString());
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
