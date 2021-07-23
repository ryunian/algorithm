package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1238 {
    private static int n,m,x, INF = 987654321, res;
    private static ArrayList<Node>[] list;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        while (m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }
        // x 에서 각 마을 까지 최단거리
        solve(x);

        // 마을(i) 에서 x 까지의 최단거리
        for (int i = 1; i <= n; i++) {
            if(i == x) continue;
            solve(i);
        }
        System.out.println(res);
    }

    private static void solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        pq.add(new Node(start, 0));

        int[] visit = new int[n+1];
        Arrays.fill(visit, INF);
        visit[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : list[cur.vertax]) {
                if(visit[next.vertax] > cur.cost + next.cost){
                    visit[next.vertax] = cur.cost + next.cost;
                    pq.add(new Node(next.vertax, visit[next.vertax]));
                }
            }
        }
        // 시작점이면 각 지점의 걸리시간을 arr에 저장한다.
        if(start == x){
            for (int i = 1; i <= n; i++) {
                arr[i] += visit[i];
            }
        }else {
            // x가 아닌 지점은 지점에서 x까지의 최단거리만 저장
            arr[start] += visit[x];
            res = Math.max(res, arr[start]);
        }

    }

    private static class Node{
        int vertax;
        int cost;

        public Node(int vertax, int cost) {
            this.vertax = vertax;
            this.cost = cost;
        }
    }
}
