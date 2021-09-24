package BOJ.Graph.Bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질 2
public class _12851 {
    public static void main(String[] args) {
        int max = 100000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[][] visit = new int[max + 1][2];
        visit[n][0] = 1;
        visit[n][1] = 1;
        int[] dx = {-1, 1, 0};
        int time = 0;
        int res = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == k) {
                System.out.println(visit[cur][0] - 1);
                System.out.println(visit[cur][1]);
                break;
            }


            for (int i = 0; i < 3; i++) {
                int next = cur + dx[i];
                if (i == 2) next *= 2;
                if (next < 0 || next > max) continue;

                if (visit[next][0] == 0) {
                    visit[next][0] = visit[cur][0] + 1;
                    visit[next][1] = visit[cur][1];
                    queue.add(next);
                }else if (visit[next][0] == visit[cur][0] + 1) {
                    visit[next][1] += visit[cur][1];
                }
            }
        }
    }
}
