package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 버블 소트
public class _1517 {
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.val));

        int log = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        int size = (int) Math.pow(2, log);
        tree = new int[size];

        long res = 0;
        for (Node node : arr) {
            int idx = node.idx;
            res += find(1, 0, n - 1, idx + 1, n - 1);
            update(1, 0, n - 1, idx, 1);
        }
        System.out.println(res);
    }

    private static void update(int node, int left, int right, int idx, int val) {
        if (left == right) {
            tree[node] = val;
            return;
        }
        int mid = (left + right) / 2;
        if (idx <= mid) {
            update(node * 2, left, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, right, idx, val);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long find(int node, int left, int right, int start, int end) {
        if (end < left || right < start) return 0;
        if (start <= left && right <= end) return tree[node];
        int mid = (left + right) / 2;

        return find(node * 2, left, mid, start, end)
                + find(node * 2 + 1, mid + 1, right, start, end);
    }
    static class Node {
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
