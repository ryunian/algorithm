package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {
    private static class Pair {
        int idx;
        int height;

        public Pair(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(n, arr);
    }

    private static void solve(int n, int[] arr) {
        int[] res = new int[n + 1];

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(n, arr[n - 1]));

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek().height) {
                Pair pair = stack.pop();
                res[pair.idx] = i + 1;
            }
            stack.push(new Pair(i + 1, arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
