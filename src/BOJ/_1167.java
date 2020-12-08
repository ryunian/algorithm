package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1167 {
    static int n,point, max = Integer.MIN_VALUE;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n; i++) {
            String[] x = br.readLine().split(" ");
            int a = Integer.parseInt(x[0]) - 1;
            loop:
            for (int j = 1; j < x.length; j += 2) {
                if ("-1".equals(x[j])) break loop;
                int b = Integer.parseInt(x[j]) - 1;
                int c = Integer.parseInt(x[j + 1]);
                list[a].add(new Node(b, c));
            }
        }

        boolean[] visit = new boolean[n];
        point = dfs(visit, 0, 0);
        visit = new boolean[n];
        dfs(visit, point, 0);

        System.out.println(max);
    }

    private static int dfs(boolean[] visit, int x, int sum) {
        visit[x] = true;
        for (Node node : list[x]) {
            if (!visit[node.to]) {
                dfs(visit, node.to, sum + node.dis);
            }
        }
        if(sum > max){
            max = sum;
            point = x;
        }
        return point;
    }

    private static class Node {
        int to;
        int dis;

        public Node(int to, int dis) {
            this.to = to;
            this.dis = dis;
        }
    }
}