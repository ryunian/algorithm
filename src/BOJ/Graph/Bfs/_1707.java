package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1707 {
    static boolean chk;
    static int v, e;
    static int[] visit;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            // 정점의 개수
            v = Integer.parseInt(st.nextToken());
            // 간선의 개수
            e = Integer.parseInt(st.nextToken());
            visit = new int[v + 1];
            list = new ArrayList[v + 1];
            chk = true;
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            for (int i = 1; i <= v; i++) {
                if (visit[i] == 0) {
                    if(!solve(i)) break;
                }
            }
            System.out.println(chk ? "YES" : "NO");
        }
    }

    private static boolean solve(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                if (visit[next] == 0) {
                    visit[next] = visit[cur] * -1;
                    queue.add(next);
                } else if (visit[cur] == visit[next]) {
                    chk = false;
                }
            }
        }
        return chk;
    }
}
