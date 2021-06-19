package BOJ.NetworkFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 네트워크 플로우 (최대 유량)
// 에드몬드 카프(Edmonds-Karp) 알고리즘
public class _1960 {
    private static int n, totolFlow, start, end, max;
    private static int[] prev;
    private static int[][] flow, capacity;
    private static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        start = 0;
        end = 2 * n + 1;
        max = end + 1;

        int rowCnt = 0;
        int colCnt = 0;

        flow = new int[max][max];
        capacity = new int[max][max];
        prev = new int[max];
        list = new ArrayList[max];
        for (int i = 0; i < max; i++) {
            list[i] = new ArrayList<>();
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            capacity[start][i] = tmp;
            rowCnt += tmp;
            list[start].add(i);
            list[i].add(start);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = n + 1; i < end; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            capacity[i][end] = tmp;
            colCnt += tmp;
            list[i].add(end);
            list[end].add(i);
        }
        if (rowCnt != colCnt) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n + 1; j < end; j++) {
                list[i].add(j);
                list[j].add(i);
                capacity[i][j] = 1;
            }
        }

        edmondsKarp();
        if (totolFlow != rowCnt) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        for (int i = 1; i <= n; i++) {
            for (int j = n + 1; j < end; j++) {
                sb.append(flow[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }

    private static void edmondsKarp() {
        while (true) {
            Arrays.fill(prev, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty() && prev[end] == -1) {
                int cur = queue.poll();

                for (int next : list[cur]) {
                    if (capacity[cur][next] > flow[cur][next] && prev[next] == -1) {
                        queue.add(next);
                        prev[next] = cur;
                    }
                }
            }

            if (prev[end] == -1) {
                return;
            }

            int value = 987654321;
            for (int i = end; i != start; i = prev[i]) {
                value = Math.min(value, capacity[prev[i]][i] - flow[prev[i]][i]);
            }

            for (int i = end; i != start; i = prev[i]) {
                flow[prev[i]][i] += value;
                flow[i][prev[i]] -= value;
            }

            totolFlow += value;
        }
    }

}
