package BOJ.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _14003 {
    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS();

        System.out.println(sb);
    }

    private static void LIS() {
        int[] lis = new int[n];
        Info[] trace = new Info[n];

        lis[0] = arr[0];
        trace[0] = new Info(0, arr[0]);
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (lis[idx] < arr[i]) {
                lis[++idx] = arr[i];
                trace[i] = new Info(idx, arr[i]);
            }else {
                int lowerBoundval = lowerBound(0, idx, arr[i], lis);
                lis[lowerBoundval] = arr[i];
                trace[i] = new Info(lowerBoundval, arr[i]);
            }
        }
        sb.append(idx + 1).append("\n");

        Stack<Integer> stack = new Stack();
        for(int i = n-1; i>= 0 ; i--){
            if (trace[i].x == idx) {
                idx--;
                stack.push(trace[i].y);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
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

    private static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
