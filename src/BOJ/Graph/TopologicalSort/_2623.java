package BOJ.Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2623 {
    static int n, m;
    static ArrayList<Integer>[] list;
    static int[] edgeCnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edgeCnt = new int[n+1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 1; j < a; j++) {
                int c = Integer.parseInt(st.nextToken());
                list[b].add(c);
                edgeCnt[c]++;
                b = c;
            }
        }

        solve();
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(edgeCnt[i] == 0) queue.add(i);
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur+"\n");
            cnt++;
            for(int next : list[cur]){
                edgeCnt[next]--;
                if(edgeCnt[next] == 0) queue.add(next);
            }
        }
        System.out.println(cnt < n ? 0 : sb.toString());

    }
}
