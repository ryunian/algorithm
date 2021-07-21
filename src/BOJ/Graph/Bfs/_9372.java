package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// MST(최소 스패닝 트리) 개념을 이용할 경우 간선의 수(정답) 는 n-1이 나온다.
public class _9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[n + 1];
            queue.add(1);
            visit[1] = true;
            int res = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : list[cur]) {
                    if (!visit[next]) {
                        res++;
                        visit[next] = true;
                        queue.add(next);
                    }
                }
            }
            System.out.println(res);
        }
    }
}
