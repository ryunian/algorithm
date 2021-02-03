package BOJ.Graph.BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11657 {
    private static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int n, m, INF = 987654321;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new Node[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(a, b, c);
        }

        solve();
    }

    private static void solve() {
        long[] arr = new long[n + 1];
        Arrays.fill(arr, INF);
        arr[1] = 0;
        boolean isPossible = true;
        int cnt = 0;
        while (isPossible && cnt <= n) {
            isPossible = false;
            for (int i = 0; i < m; i++) {
                int x = nodes[i].x;
                int y = nodes[i].y;
                int cost = nodes[i].cost;
                if (arr[x] != INF && arr[y] > arr[x] + cost) {
                    arr[y] = arr[x] + cost;
                    isPossible = true;
                }
            }
            cnt++;
        }
        if (isPossible) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                sb.append(arr[i] == INF ? -1 : arr[i]);
                if (i != n) sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}
