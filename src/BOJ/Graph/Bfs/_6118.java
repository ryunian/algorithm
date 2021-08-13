package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질
public class _6118 {
    static int n, m;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] visit = new int[n + 1];
        visit[1] = 1;

        int a = Integer.MAX_VALUE, b = 0;
        int max = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (max < visit[cur]) {
                a = Integer.MAX_VALUE;
                b = 0;
                max = visit[cur];
            }

            if (max == visit[cur]) {
                a = Math.min(a, cur);
                b++;
            }

            for (int next : list[cur]) {
                if (visit[next] == 0) {
                    visit[next] = visit[cur] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println(a + " " + (max - 1) + " " + b);
    }
}
