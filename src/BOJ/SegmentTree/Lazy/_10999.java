package BOJ.SegmentTree.Lazy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 2
// Segment tree with lazy
public class _10999 {
    static int n, m, k;
    static long[] arr, tree, lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        tree = new long[n * 4];
        lazy = new long[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(1, 1, n, b, c, d);
            } else {
                long res = find(1, 1, n, b, c);
                sb.append(res + "\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static long init(int node, int left, int right) {
        if (left == right) {
            return tree[node] = arr[left];
        }

        int mid = (left + right) / 2;
        return tree[node]
                = init(node * 2, left, mid)
                + init(node * 2 + 1, mid + 1, right);
    }

    private static long find(int node, int left, int right, int i, int j) {
        updateLazy(node, left, right);

        // 구간 밖으로 나갔으므로 탈출
        if (j < left || right < i) return 0;
        // 구간 안에 속해있으면 값을 리턴한다.
        if (i <= left && right <= j) return tree[node];

        int mid = (left + right) / 2;
        return find(node * 2, left, mid, i, j)
                + find(node * 2 + 1, mid + 1, right, i, j);
    }

    private static void updateLazy(int node, int left, int right) {
        if (lazy[node] != 0) {
            // 현재 구간의 값을 갱신해준다.
            tree[node] += (right - left + 1) * lazy[node];

            // leaf node 가 아니면 자식의 lazy 에 갱신해준다.
            if (left != right) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            // 갱신 했으므로 초기화
            lazy[node] = 0;
        }
    }

    private static void update(int node, int left, int right, int i, int j, long diff) {
        // lazy update
        updateLazy(node, left, right);

        // 경계밖에 있을떄
        if (j < left || right < i) return;

        // 대표 구간을 찾았을떄
        if (i <= left && right <= j) {
            tree[node] += diff * (right - left + 1);
            if (left != right) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }

        int mid = (left + right) / 2;
        update(node * 2, left, mid, i, j, diff);
        update(node * 2 + 1, mid + 1, right, i, j, diff);

        // 자식이 업데이트 됬으므로 본인의 값도 최신화
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}
