package BOJ.Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1005 {
    static int q, w, goal;
    static int[] cost, edgeCnt;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            // 건물의 개수
            q = Integer.parseInt(st.nextToken());
            // 규칙의 개수
            w = Integer.parseInt(st.nextToken());

            // 비용
            cost = new int[q + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= q; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            // 정점의 간선 수
            edgeCnt = new int[q + 1];
            // 인접리스트
            list = new ArrayList[q + 1];
            for (int j = 1; j <= q; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                edgeCnt[b]++;
            }
            goal = Integer.parseInt(br.readLine());

            solve();
        }


    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList();
        int[] dp = new int[q+1];
        for (int i = 1; i <= q; i++) {
            if (edgeCnt[i] == 0){
                queue.add(i);
                dp[i] = cost[i];
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int next : list[cur]) {
                if(--edgeCnt[next] == 0) {
                    queue.add(next);
                }
                dp[next] = Math.max(dp[cur] + cost[next] , dp[next]);
            }
        }
//        System.out.println(Arrays.toString(cost));
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[goal]);
    }
}
