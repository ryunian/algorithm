package BOJ.Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2056 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //비용
        int[] cost = new int[n + 1];
        // 연결된 간선의 수
        int[] edgeCnt = new int[n + 1];
        // 이중리스트
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        // dp
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            cost[i] = a;
            dp[i] = a;
            edgeCnt[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= edgeCnt[i]; j++) {
                int b = Integer.parseInt(st.nextToken());
                list[b].add(i);
            }
        }

        topologicalSort(cost, edgeCnt, list, dp);
    }

    private static void topologicalSort(int[] cost, int[] edgeCnt, ArrayList<Integer>[] list, int[] dp) {
        Queue<Integer> queue = new LinkedList<>();
        // 간선의 수가 0인 정점 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (edgeCnt[i] == 0) {
                queue.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int v = queue.poll();
            for (int next : list[v]) {
                edgeCnt[next]--;
                dp[next] = Math.max(dp[next], dp[v] + cost[next]);
                if (edgeCnt[next] == 0) queue.add(next);
            }
        }
//        System.out.println(Arrays.toString(cost));
//        System.out.println(Arrays.toString(dp));
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }

}
