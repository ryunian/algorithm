package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2357 {
    static long[] minTree, maxTree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = 0;
        while(n >= Math.pow(2,k)){
            k++;
        }

        arr = new long[n + 1];
        minTree = new long[(int) Math.pow(2,k+1)]; // 추후로 이값을 제대로 구하기
        maxTree = new long[n * 4];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        minInit(1, 1, n);
        maxInit(1, 1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long min = minValue(1, 1, n, a, b);
            long max = maxValue(1, 1, n, a, b);
            sb.append(min + " " + max + "\n");
//            System.out.println(min);
        }
        System.out.println(sb.toString());
    }

    // 최솟값 세그먼트 트리 초기화
    private static long minInit(int node, int start, int end) {
        if (start == end) {
            return minTree[node] = arr[start];
        }
        int mid = (start + end) / 2;

        return minTree[node] = Math.min(minInit(node * 2, start, mid), minInit(node * 2 + 1, mid + 1, end));
    }

    // 최댓값 세그먼트 트리 초기화
    private static long maxInit(int node, int start, int end) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }
        int mid = (start + end) / 2;

        return maxTree[node] = Math.max(maxInit(node * 2, start, mid), maxInit(node * 2 + 1, mid + 1, end));
    }

    // 최소값 검색
    private static long minValue(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(minValue(node * 2, start, mid, left, right), minValue(node * 2 + 1, mid + 1, end, left, right));

    }

    // 최댓값 검색
    private static long maxValue(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Long.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;
        return Math.max(maxValue(node * 2, start, mid, left, right), maxValue(node * 2 + 1, mid + 1, end, left, right));

    }
}
