package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1916 {
    private static class Node {
        int arrival;
        int cost;

        public Node(int arrival, int cost) {
            this.arrival = arrival;
            this.cost = cost;
        }
    }

    static int n, m, start, end;
    static ArrayList<Node>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
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
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        queue.add(new Node(start, 0));
        int[] arr = new int[n+1];
        Arrays.fill(arr, 987654321);
        arr[start] = 0;

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.arrival == end){
                System.out.println(cur.cost);
                break;
            }

            for(Node next : list[cur.arrival]){
                if(arr[next.arrival] > arr[cur.arrival] + next.cost){
                    arr[next.arrival] = arr[cur.arrival] + next.cost;
                    queue.add(new Node(next.arrival,arr[next.arrival]));
                }
            }
        }
    }
}
