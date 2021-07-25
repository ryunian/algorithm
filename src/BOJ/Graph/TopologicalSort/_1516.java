package BOJ.Graph.TopologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1516 {
    static int n;
    static int[] recvCnt, times;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        recvCnt = new int[n + 1];
        times = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) break;
                recvCnt[i]++;
                list[tmp].add(i);
            }
        }

        solve();
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(recvCnt[i] == 0){
                queue.add(i);
                res[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : list[cur]){
                recvCnt[next]--;
                res[next] = Math.max(res[next] , times[next] + res[cur]);

                if(recvCnt[next] == 0){
                    queue.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}
