package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String p = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
            Deque<String> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                deque.add(arr[i]);
            }

            solve(p, deque);
        }
    }

    private static void solve(String p, Deque<String> deque) {
        int order = 1;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == 'R') order *= -1;
            else {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                // 오름차순
                if (order == 1) {
                    deque.poll();
                }
                // 내림차순
                else {
                    deque.pollLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
            if (order == 1) {
                sb.append(deque.poll());
            } else {
                sb.append(deque.pollLast());
            }
            if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
