package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10868 {
    static int n, m;
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        tree = new int[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, n);
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = find(1, 1, n, a, b);
            sb.append(x+"\n");
        }
        System.out.print(sb.toString());
    }

    private static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[end];
        }

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
    }

    private static int find(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(find(node * 2, start, mid, left, right), find(node * 2 + 1, mid + 1, end, left, right));
    }
}
