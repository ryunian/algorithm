package BOJ.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16562 {
    static int n, m, money;
    static int[] arr, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visit = new boolean[n + 1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        for (int i = 1; i <= n; i++) {
            int x = find(i);
            if(!visit[x]){
                visit[x] = true;
                res += cost[x];
            }
        }
        System.out.println(res > money ? "Oh no" : res);
    }

    private static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    private static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (cost[a] > cost[b]) {
            return arr[a] = b;
        } else {
            return arr[b] = a;
        }
    }
}
