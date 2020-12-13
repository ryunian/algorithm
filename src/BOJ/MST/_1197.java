package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1197 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Node[] node = new Node[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            node[i] = new Node(a, b, c);
        }
        Arrays.sort(node, (o1, o2) -> o1.dis - o2.dis);
        kruskal(node);

    }

    private static void kruskal(Node[] node) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(node[0].start, node[0].end, node[0].dis));
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int sum = 0;
        for (int i = 0; i < node.length; i++) {
            int a = find(node[i].start);
            int b = find(node[i].end);
            if(a != b){
                union(a,b);
                sum += node[i].dis;
            }
        }
        System.out.println(sum);

    }

    private static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        arr[a] = b;
    }

    private static class Node {
        int start;
        int end;
        int dis;

        public Node(int start, int end, int dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }
    }
}
