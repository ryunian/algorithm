package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1967 {
    static ArrayList<Edge>[] list;
    static boolean[] visit;
    static int max= Integer.MIN_VALUE, target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        list = new ArrayList[n+1];
        visit = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }

        int leaf = dfs(1,0);
//        System.out.println(leaf);
        visit = new boolean[n+1];
        dfs(leaf,0);
        System.out.println(max);
    }

    private static int dfs(int x, int val) {
        visit[x] = true;
        if(list[x] != null) {
            for (Edge edge : list[x]) {
                if (!visit[edge.pos]) {
                    visit[edge.pos] = true;
                    dfs(edge.pos, val + edge.dis);
                }
            }
        }
        if(max < val){
            max = val;
            target = x;
        }
        return target;
    }


    private static class Edge{
        int pos;
        int dis;
        public Edge(int pos, int dis){
            this.pos = pos;
            this.dis = dis;
        }
    }
}
