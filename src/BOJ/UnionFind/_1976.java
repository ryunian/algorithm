package BOJ.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int tmp = find(Integer.parseInt(st.nextToken()));
        boolean isPossible = true;
        while (m-- > 1) {
            int x = Integer.parseInt(st.nextToken());
            if (tmp != find(x)) {
                isPossible = false;
            }
        }
        System.out.println(isPossible ? "YES" : "NO");
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
}
