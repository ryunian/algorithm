package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17220 {
    // 0 : 원산지
    // 1 : 공급책
    // -1 : 검거했거나 방문한 곳
    static int[] visit;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new int[n];
        list = new ArrayList[n];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            char[] c = br.readLine().toCharArray();
            int a = c[0] - 'A';
            int b = c[2] - 'A';
            list[a].add(b);
            visit[b] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int query = Integer.parseInt(st.nextToken());
        while (query-- > 0) {
            int x = st.nextToken().charAt(0) - 'A';
            visit[x] = -1;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visit.length; i++) {
            // 먀약의 원산지면서, 검거당한 공급책이 아닐 경우
            if(visit[i] == 0){
                queue.add(i);
                visit[i] = -1;
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                if (visit[next] == 1) {
                    visit[next] = -1;
                    queue.add(next);
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
