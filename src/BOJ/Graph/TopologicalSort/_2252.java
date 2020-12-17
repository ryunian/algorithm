package BOJ.Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2252 {
    static int n, m;
    static int[] edgeCnt;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 학생 수
        n = Integer.parseInt(st.nextToken());
        // 비교한 횟수
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        edgeCnt = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            edgeCnt[b]++;
        }
        solve();
        System.out.println(sb.toString());
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (edgeCnt[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur+" ");
            for(int next : list[cur]){
                edgeCnt[next]--;
                if(edgeCnt[next] == 0){
                    queue.add(next);
                }
            }
        }
    }
}
