package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열과 쿼리 15
public class _14427 {
    static int n;
    static int[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tree = new int[n * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, n);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 2) {
                sb.append(tree[1] + "\n");
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[b] = c;
                update(1, 1, n, b);
            }
        }
        System.out.print(sb);
    }

    private static int update(int node, int left, int right, int idx) {
        if (idx < left || right < idx || left == right) return tree[node];

        int mid = (left + right) / 2;
        int a = update(node * 2, left, mid, idx);
        int b = update(node * 2 + 1, mid + 1, right, idx);
        int min = arr[a] <= arr[b] ? a : b;
        return tree[node] = min;
    }

    private static int init(int node, int left, int right) {
        if (left == right) return tree[node] = left;

        int mid = (left + right) / 2;

        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        int idx = arr[a] <= arr[b] ? a : b;
        return tree[node] = idx;
    }
}
