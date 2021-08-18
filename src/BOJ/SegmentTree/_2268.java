package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수들의 합
public class _2268 {
    static long[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new long[n * 4];
        arr = new long[n + 1];
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, n, b, diff);
            } else {
                int nb = Math.min(b,c);
                int nc = Math.max(b,c);
                sb.append(find(1, 1, n, nb, nc)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static long find(int node, int left, int right, int i, int j) {
        if (j < left || right < i) return 0;
        if (i <= left && right <= j) return tree[node];

        int mid = (left + right) / 2;
        return find(node * 2, left, mid, i, j) +
                find(node * 2 + 1, mid + 1, right, i, j);
    }

    public static void update(int node, int left, int right, int idx, long diff) {
        if (idx < left || right < idx) return;

        tree[node] += diff;
        if (left != right) {
            int mid = (left + right) / 2;
            update(node * 2, left, mid, idx, diff);
            update(node * 2 + 1, mid + 1, right, idx, diff);
        }
    }
}
