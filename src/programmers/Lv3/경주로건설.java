package programmers.Lv3;

import java.util.*;

public class 경주로건설 {
    public static void main(String[] args) {
        경주로건설 test = new 경주로건설();
        test.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        test.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}});
        test.solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}});
        test.solution(new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}});
        test.solution(new int[][]{{0, 1, 1, 1, 1, 1, 1, 1, 1},{0, 0, 0, 0, 0, 1, 1, 1, 1},{1, 1, 1, 1, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1},{0, 1, 0, 1, 1, 1, 1, 1, 1},{0, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1, 1, 1},{0, 0, 0, 0, 0, 1, 1, 1, 1},{1, 1, 1, 1, 0, 0, 0, 0, 0}});

    }

    public int solution(int[][] board) {
        int max = board.length;
        int answer = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        pq.add(new Node(0, 0, 0, 0));
        pq.add(new Node(0, 0, 1, 0));

        int[][][] visit = new int[max][max][4];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                Arrays.fill(visit[i][j], INF);
            }
        }
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.x== max-1 && cur.y == max -1){
                answer = cur.cost;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nCost = cur.dir == i ? cur.cost + 100 : cur.cost + 600;

                if (nx < 0 || ny < 0 || nx >= max || ny >= max) continue;
                if (board[nx][ny] == 1) continue;

                if (visit[nx][ny][cur.dir] > nCost) {
                    visit[nx][ny][cur.dir] = nCost;
                    pq.add(new Node(nx, ny, i, nCost));
                }
            }
        }

        return answer;
    }

    int INF = 987654321;
    // 남 동 북 서
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    class Node {
        int x;
        int y;
        int dir;
        int cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
