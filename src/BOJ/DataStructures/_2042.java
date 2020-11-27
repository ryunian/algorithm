package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2042 {
    static int n, m, l;
    static long[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

//        System.out.println(Arrays.toString(arr));
        init(1, 1, n);
        System.out.println(Arrays.toString(tree));
        for (int i = 0; i < m + l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                long dif = c - arr[b];
                arr[b] = c;
                update(1, 1, n, b, dif);
            } else if (a == 2) {
                long value = sum(1, 1, n, b, (int)c);
                sb.append(value + "\n");
//                System.out.println(">>>>>>>>>> "+value);
            }
        }
        System.out.println(sb.toString());
    }

    // 초기화
    private static long init(int node, int start, int end) {
        // 트릐의 리프
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    // 계산
    private static long sum(int node, int start, int end, int left, int right) {
        // 하나도 포함되지 않을 경우
        if (left > end || right < start) {
            return 0;
        }
        // 포함이 되어 있을 경우
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }


    /*
     * node : node
     * start : 시작
     * end : 마지막
     * index : 바꾸는 위치
     * diff : 기존값과의 차이
     */
    private static void update(int node, int start, int end, int index, long diff) {
        if (index < start || index > end) {
            return;
        }

        tree[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }
}
