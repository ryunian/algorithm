package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 곱 구하기
public class _11505 {
    static int[] arr;
    static long[] segment;
    static int n, m, k, MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        segment = new long[4 * n];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 1, n, b, c);
            } else {
                sb.append(find(1, 1, n, b, c)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static long init(int node, int left, int right) {
        if (left == right) {
            return segment[node] = arr[left];
        }
        int mid = (left + right) / 2;
        return segment[node]
                = init(node * 2, left, mid)
                * init(node * 2 + 1, mid + 1, right)
                % MOD;
    }

    private static long find(int node, int left, int right, int start, int end) {
        if (end < left || right < start) {
            return 1;
        }

        if (start <= left && right <= end) {
            return segment[node];
        }
        int mid = (left + right) / 2;
        return find(node * 2, left, mid, start, end)
                * find(node * 2 + 1, mid + 1, right, start, end)
                % MOD;
    }

    private static long update(int node, int left, int right, int index, long val) {
        if (index < left || right < index) {
            return segment[node];
        }
        if (left == right) {
            return segment[node] = val;
        }
        int mid = (left + right) / 2;
        return segment[node]
                = update(node * 2, left, mid, index, val)
                * update(node * 2 + 1, mid + 1, right, index, val)
                % MOD;
    }
}
