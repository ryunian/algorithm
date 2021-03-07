package programmers.Lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        가장먼노드 test = new 가장먼노드();
        test.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});

    }


    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }

        return bfs(n, list);
    }

    private int bfs(int n, ArrayList<Integer>[] list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] visit = new int[n + 1];
        visit[1] = 1;
        int max = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            max = Math.max(max, visit[cur]);

            for(int next : list[cur]){
                if(visit[next] == 0){
                    visit[next] = visit[cur]+1;
                    queue.add(next);
                }
            }
        }
        int res = 0;
        for(int x : visit){
            if(x == max) res++;
        }

        return res;
    }
}
