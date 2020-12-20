package BOJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2568 {
    static int n;
    static Pair[] arr, trace;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Pair[n];
        trace = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(a, b);
        }
        // x 기준으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> o1.x - o2.x);

        // 최장 증가 수열
        int cnt = LIS();
        sb.append(n - (cnt + 1) + "\n");

        int[] deleteLine = new int[n - (cnt + 1)];
        int idx = 0;
        while (n-- > 0) {
            if (trace[n].y == cnt) {
                cnt--;
            } else {
                deleteLine[idx++] = trace[n].x;
            }
        }

        Arrays.sort(deleteLine);
        for (int a : deleteLine) {
            sb.append(a + "\n");
        }

        System.out.println(sb);
    }

    private static int LIS() {
        // lis을 구현하기 위한 임시 배열
        int[] lis = new int[n];

        // 초기값 설정
        trace[0] = new Pair(arr[0].x, 0);
        lis[0] = arr[0].y;

        int idx = 0;
        for (int i = 1; i < n; i++) {
            // 마지막값보다 클시 그뒤에 넣는다.
            if (lis[idx] < arr[i].y) {
                lis[++idx] = arr[i].y;
                trace[i] = new Pair(arr[i].x, idx);
            }
            //
            else {
                // lis 배열에서 바꿔야되는 위치 탐색
                int lowerBoundVal = lowerBound(0, idx, arr[i].y, lis);
                lis[lowerBoundVal] = arr[i].y;
                trace[i] = new Pair(arr[i].x, lowerBoundVal);
            }
        }

        return idx;
    }

    private static int lowerBound(int left, int right, int val, int[] lis) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
