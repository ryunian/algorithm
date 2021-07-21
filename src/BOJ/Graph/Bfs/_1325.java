package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1325 {
    static int n, max = 0;
    static ArrayList<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[b].add(a);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            res[i] = bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (res[i] == max) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
        return cnt;
    }
}
