package BOJ.Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1766 {
    static int n, m;
    static int[] recvCnt;
    static ArrayList<Integer> res;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        recvCnt = new int[n + 1];
        res = new ArrayList<>();
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            recvCnt[b]++;
        }

        solve();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)+" ");
        }
        System.out.println(sb);
    }

    // 위상정렬
    private static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 1; i <= n; i++) {
            if (recvCnt[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            res.add(cur);

            for (int next : list[cur]) {
                recvCnt[next]--;

                if (recvCnt[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }
}
