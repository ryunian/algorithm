package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 단절점
// 단절점과 같이 DFS를 이용하는 방식으로
//   A번째 정점에서 부모로 가는 간선이 아닌 간선 중에서
//   아직 방문안한 노드의 방문번호가 현재 방문번호보다 클 경우 단절선이 된다.
public class _11400 {
    static int n, m, cnt = 0;
    static int[] visit;
    static ArrayList<Integer>[] list;
    static PriorityQueue<Edge> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // x를 기준으로 오름차순 정렬, 같을 경우 y를 기준으로 오름차순 정렬
        result = new PriorityQueue<>(Comparator.comparing(Edge::getX).thenComparing(Edge::getY));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new int[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                dfs(0, i);
            }
        }

        // result
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        while (!result.isEmpty()) {
            Edge e = result.poll();
            sb.append(e.x + " " + e.y + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int dfs(int parent, int cur) {
        visit[cur] = ++cnt;
        int ret = visit[cur];

        for (int next : list[cur]) {
            if (next == parent) continue;

            // 방문했을 경우 ret에 저장후, continue
            if (visit[next] != 0) {
                ret = Math.min(ret, visit[next]);
                continue;
            }

            // 아직 방문 안한 노드
            int prev = dfs(cur, next);

            // 현재 방문번호보다 클 경우 단절선이다.
            if (prev > visit[cur]) {
                int a = Math.min(next, cur);
                int b = Math.max(cur, next);
                result.add(new Edge(a, b));
            }

            ret = Math.min(ret, prev);
        }

        return ret;
    }

    private static class Edge {
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}



