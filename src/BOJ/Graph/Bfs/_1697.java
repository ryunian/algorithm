package BOJ.Graph.Bfs;

import java.io.*;
import java.util.*;

public class _1697 {
    public static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bfs(n, m);
    }

    private static void bfs(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == m) {
                System.out.println(check[temp] - 1);
                break;
            }
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                if (next >= 0 && next <= 100000 && check[next] == 0) {
                    check[next] = check[temp] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
