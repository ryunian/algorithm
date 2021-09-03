package BOJ.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _16202 {
    static int tmp;
    static int[] parent, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        res = new int[k];
        parent = new int[n + 1];
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, i));
        }

        list.sort(Comparator.comparingInt(o -> o.cost));
        for (int i = 0; i < k; i++) {
            int idx = -1;
            int cnt = 0;
            tmp = 0;
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }
            for (int j = 0; j < list.size(); j++) {
                if (union(list.get(j))) {
                    cnt++;
                    if (idx == -1) {
                        idx = j;
                    }
                }
            }
            if (idx != -1) {
                list.remove(idx);
            }
            if (cnt == n - 1) {
                res[i] = tmp;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb.toString());
    }

    private static boolean union(Node node) {
        int a = find(node.prev);
        int b = find(node.next);

        if (a != b) {
            parent[a] = b;
            tmp += node.cost;
            return true;
        }
        return false;
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
}
