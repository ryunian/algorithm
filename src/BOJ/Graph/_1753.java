package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class _1753 {
    static int n, m, first;
    static int[] arr;
    static boolean[] check;
    static ArrayList<Node>[] list;

    private static class Node {
        int idx;
        int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        first = Integer.parseInt(br.readLine());

        check = new boolean[n + 1];
        arr = new int[n + 1];
        int max = Integer.MAX_VALUE / 2;
        Arrays.fill(arr, max);

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        solution();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == max) sb.append("INF\n");
            else sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solution() {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.distance - o2.distance);
        queue.add(new Node(first, 0));
        arr[first] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (check[current.idx]) continue;
            check[current.idx] = true;

            for (Node next : list[current.idx]) {
                if (arr[next.idx] > arr[current.idx] + next.distance) {
                    arr[next.idx] = arr[current.idx] + next.distance;
                    queue.add(new Node(next.idx, arr[next.idx]));
                }
            }
        }


    }

}
