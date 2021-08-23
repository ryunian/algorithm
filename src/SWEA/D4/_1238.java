package SWEA.D4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _1238 {
    static int n, start, max = 101;
    static List<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            n = sc.nextInt();
            start = sc.nextInt();
            list = new LinkedList[max];
            for (int i = 0; i < max; i++) {
                list[i] = new LinkedList<>();
            }
            for (int i = 0; i < n; i += 2) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                list[from].add(to);
            }
            System.out.printf("#%d %d\n", tc, bfs());
        }
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] visit = new int[max];
        visit[start] = 1;

        int max = 0;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            max = Math.max(max, cur);
            if (visit[cur] > cnt) {
                max = cur;
                cnt = visit[cur];
            }

            for (int next : list[cur]) {
                if (visit[next] != 0) continue;
                visit[next] = visit[cur] + 1;
                queue.add(next);
            }
        }
        return max;
    }
}