package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 4 (Segment Tree 버전)
public class _11659 {
    private static int[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        tree = new int[1 << (h + 1)];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

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
            int res = find(1, 1, n, a, b);
            sb.append(res + "\n");
        }
        System.out.print(sb);
    }

    private static int find(int node, int left, int right, int start, int end) {
        if (right < start || end < left) return 0;
        if (start <= left && right <= end) {
            return tree[node];
        }
        int mid = (left + right) / 2;
        return find(node * 2, left, mid, start, end)
                + find(node * 2 + 1, mid + 1, right, start, end);
    }

    private static int init(int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        int mid = (left + right) / 2;
        return tree[node] = init(node * 2, left, mid)
                + init(node * 2 + 1, mid + 1, right);
    }
}
