package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15591 {
    private static ArrayList<Node>[] list;
    private static ArrayList<Integer>[] usado;
    private static boolean[] visit;
    private static int n,q, INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        usado = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            usado[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        for (int i = 1; i <=n; i++) {
            bfs(i);
        }
//        Arrays.stream(usado).forEach(s -> System.out.println(s));

        StringBuilder sb = new StringBuilder();
        while (q-- > 0){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int x : usado[idx]){
                if(x >= val) cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, INF));

        visit = new boolean[n+1];
        visit[start] = true;

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node next : list[cur.vertax]){
                if(!visit[next.vertax]){
                    visit[next.vertax] = true;
                    int min = Math.min(cur.usado, next.usado);
                    usado[start].add(min);
                    queue.add(new Node(next.vertax, min));
                }
            }
        }
    }

    private static class Node{
        int vertax;
        int usado;

        public Node(int vertax, int usado) {
            this.vertax = vertax;
            this.usado = usado;
        }
    }
}