package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 하나로 kruskal version
public class _1251 {
    static int n;
    static int[] a, b, parent;
    static double E;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1, st2;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            a = new int[n];
            b = new int[n];

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st1.nextToken());
                b[i] = Integer.parseInt(st2.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            list = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    long x = Math.abs(a[i] - a[j]);
                    long y = Math.abs(b[i] - b[j]);
                    list.add(new Edge(i, j, x * x + y * y));
                }
            }

            // kruskal
            long res = kruskal();
            sb.append(String.format("#%d %d\n", tc, Math.round(res * E)));
        }
        System.out.print(sb.toString());
    }

    private static long kruskal() {
        list.sort(Comparator.comparingLong(o -> o.cost));
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        long ret = 0;
        int cnt = 0;
        for (Edge edge : list) {
            if (union(edge)) {
                ret += edge.cost;
                if (++cnt == n - 1) break;
            }
        }
        return ret;
    }


    private static boolean union(Edge edge) {
        int a = find(edge.prev);
        int b = find(edge.next);

        if (a != b) {
            parent[a] = b;
            return true;
        }
        return false;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static class Edge {
        int prev, next;
        long cost;

        public Edge(int prev, int next, long cost) {
            this.prev = prev;
            this.next = next;
            this.cost = cost;
        }
    }
}
