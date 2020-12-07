package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2606 {
    static int n, m;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        list = new ArrayList();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visit[0] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int val = queue.poll();

            for (int x : list.get(val)) {
                if (!visit[x]) {
                    visit[x] = true;
                    queue.add(x);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
