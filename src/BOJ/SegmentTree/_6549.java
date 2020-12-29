package BOJ.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6549 {
    static int n;
    static int[] segmentTree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            arr = new int[n];
            segmentTree = new int[n * 4];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            init(1, 0, n - 1);
            System.out.println(solve(0, n - 1));
        }

    }

    private static int init(int node, int start, int end) {
        if (start == end) {
            return segmentTree[node] = start;
        }
        int mid = (start + end) / 2;

        int leftMinIdx = init(node * 2, start, mid);
        int rightMinIdx = init(node * 2 + 1, mid + 1, end);

        return segmentTree[node] =
                arr[leftMinIdx] < arr[rightMinIdx] ? leftMinIdx : rightMinIdx;
    }


    private static int find(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return -1;
        }
        if (left <= start && end <= right) {
            return segmentTree[node];
        }
        int mid = (start + end) / 2;
        int x = find(node * 2, start, mid, left, right);
        int y = find(node * 2 + 1, mid + 1, end, left, right);
        if (x == -1) {
            return y;
        } else if (y == -1) {
            return x;
        } else {
            if (arr[x] <= arr[y]) {
                return x;
            } else {
                return y;
            }
        }
    }

    private static long solve(int left, int right) {
        int idx = find(1, 0, arr.length - 1, left, right);

        long area = (long)(right - left + 1) * (long)arr[idx];

        if (left <= idx - 1) {
            long temp = solve(left, idx - 1);
            if (area < temp) {
                area = temp;
            }
        }
        if (right >= idx + 1) {
            long temp = solve(idx + 1, right);
            if (area < temp) {
                area = temp;
            }
        }

        return area;
    }
}
