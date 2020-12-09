package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11725 {
    static ArrayList<Integer>[] list;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visit = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n-1; i++) {
            String[] x = br.readLine().split(" ");
            int a = Integer.parseInt(x[0]);
            int b = Integer.parseInt(x[1]);
            list[a].add(b);
            list[b].add(a);
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(visit[i]+"\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        visit[1] = 1;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int y : list[x]){
                if(visit[y] == 0){
                    visit[y] = x;
                    queue.add(y);
                }
            }
        }

    }
}
