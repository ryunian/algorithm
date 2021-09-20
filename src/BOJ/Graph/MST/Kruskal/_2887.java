package BOJ.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 행성 터널
public class _2887 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        List<Pair> x = new ArrayList<>(n);
        List<Pair> y = new ArrayList<>(n);
        List<Pair> z = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x.add(new Pair(i, Integer.parseInt(st.nextToken())));
            y.add(new Pair(i, Integer.parseInt(st.nextToken())));
            z.add(new Pair(i, Integer.parseInt(st.nextToken())));
            parent[i] = i;
        }
        x.sort(null);
        y.sort(null);
        z.sort(null);

        ArrayList<Node> list = new ArrayList<>(n * 3 + 1);
        for (int i = 0; i < n - 1; i++) {
            list.add(new Node(x.get(i).idx, x.get(i + 1).idx, x.get(i + 1).val - x.get(i).val));
            list.add(new Node(y.get(i).idx, y.get(i + 1).idx, y.get(i + 1).val - y.get(i).val));
            list.add(new Node(z.get(i).idx, z.get(i + 1).idx, z.get(i + 1).val - z.get(i).val));
        }
        list.sort(Comparator.comparing(o -> o.cost));


        int res = 0;
        int cnt = 0;
        for (Node node : list) {
            if (!union(node.prev, node.next)) continue;
            res += node.cost;
            if (++cnt == n - 1) break;
        }
        System.out.println(res);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        parent[a] = b;
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }


    static class Node {
        int prev, next, cost;

        public Node(int prev, int next, int cost) {
            this.prev = prev;
            this.next = next;
            this.cost = cost;
        }
    }

    static class Pair implements Comparable<Pair> {
        int idx;
        int val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
}
