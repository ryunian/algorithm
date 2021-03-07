package programmers.Lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        디스크컨트롤러 test = new 디스크컨트롤러();
        test.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        test.solution(new int[][]{{0, 9}, {1, 3}, {6, 8}, {2, 7}});
        test.solution(new int[][]{{0, 5}, {4, 1}, {1, 3}});
        test.solution(new int[][]{{0, 5}, {7, 1}, {7, 3}});

//        test.solution(new int[][]{{0, 10}, {2, 10}, {9, 10}, {15, 2}}) ; //, 14) ; //
//        test.solution(new int[][]{{0, 10}, {2, 12}, {9, 19}, {15, 17}}) ; //, 25) ; //
//        test.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}) ; //, 9) ; //
//        test.solution(new int[][]{{0, 1}}) ; //, 1) ; //
//        test.solution(new int[][]{{1000, 1000}}) ; //, 1000) ; //
//        test.solution(new int[][]{{0, 1}, {0, 1}, {0, 1}}) ; //, 2) ; //
//        test.solution(new int[][]{{0, 1}, {0, 1}, {0, 1}, {0, 1}}) ; //, 2) ; //
        test.solution(new int[][]{{0, 1}, {1000, 1000}}); //, 500) ; //
        test.solution(new int[][]{{100, 100}, {1000, 1000}}); //, 500) ; //
//        test.solution(new int[][]{{10, 10}, {30, 10}, {50, 2}, {51, 2}}) ; //, 6) ; //
//        test.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}, {30, 3}}) ; //, 7) ; //
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Node> job = new PriorityQueue<>(Comparator.comparing(o -> o.x));
        int max = 0;
        for (int i = 0; i < jobs.length; i++) {
            job.add(new Node(jobs[i][0], jobs[i][1]));
            max += jobs[i][1];
        }
        int cntWait = 0;
        int cntJob = 0;
        int sum = 0;
        PriorityQueue<Node> tmp = new PriorityQueue<>((o1, o2) ->
                o1.y - o2.y == 0 ? o1.x - o2.x : o1.y - o2.y);
        while (sum < max) {
            while (!job.isEmpty() && job.peek().x <= sum) {
                Node cur = job.poll();
                tmp.add(new Node(cur.x, cur.y));
            }
            if (!tmp.isEmpty()) {
                cntJob += sum - tmp.peek().x;
                cntWait += tmp.peek().y;
                sum += tmp.peek().y;

                tmp.poll();
            } else {
                sum++;
            }
        }
        System.out.println(cntWait + " " + cntJob);
        System.out.println((cntWait + cntJob) / jobs.length);
        return (cntWait + cntJob) / jobs.length;
    }

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
