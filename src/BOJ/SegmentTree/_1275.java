package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 커피숍 2
public class _1275 {
    static int n, m;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        tree = new long[4 * n];
        init(1, 1, n);

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            sb.append(find(1, 1, n, a, b) + "\n");

            int c = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long diff = d - arr[c];
            arr[c] = d;
            update(1, 1, n, c, diff);
        }
        System.out.print(sb.toString());
    }

    private static long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        return tree[node] = init(node * 2, left, mid)
                + init(node * 2 + 1, mid + 1, right);
    }

    private static long find(int node, int left, int right, int min, int max) {
        if (right < min || max < left) return 0;
        if (min <= left && right <= max) return tree[node];

        int mid = (left + right) / 2;
        return find(node * 2, left, mid, min, max)
                + find(node * 2 + 1, mid + 1, right, min, max);
    }

    private static void update(int node, int left, int right, int idx, long diff) {
        if (idx < left || right < idx) return;

        tree[node] += diff;
        if (left != right) {
            int mid = (left + right) / 2;
            update(node * 2, left, mid, idx, diff);
            update(node * 2 + 1, mid + 1, right, idx, diff);
        }
    }
}