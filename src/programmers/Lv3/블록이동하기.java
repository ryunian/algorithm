package programmers.Lv3;

import java.util.*;

// 블록 이동하기
// 테스트 14 : 통과 (32.43ms, 79.3MB)
public class 블록이동하기 {
    public static void main(String[] args) {
        블록이동하기 test = new 블록이동하기();
        test.solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}});
    }

    int[][] board;
    int n;
    // 상 우 하 좌
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        n = board.length;
        this.board = board;
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(0, 0, 0, 1, 0, 0);
        queue.add(start);
        Set<Node> set = new HashSet<>();
        set.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x1 == n - 1 && cur.y1 == n - 1) {
                answer = cur.cnt;
                break;
            } else if (cur.x2 == n - 1 && cur.y2 == n - 1) {
                answer = cur.cnt;
                break;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx1 = cur.x1 + dx[i];
                int ny1 = cur.y1 + dy[i];
                int nx2 = cur.x2 + dx[i];
                int ny2 = cur.y2 + dy[i];
                if (!isCheck(nx1, ny1, nx2, ny2)) continue;

                Node node = new Node(nx1, ny1, nx2, ny2, cur.status, cur.cnt + 1);
                if (!set.contains(node)) {
                    set.add(node);
                    queue.add(node);
                }
            }
            // 회전
            for (int i = 0; i < 2; i++) {
                int dir = (cur.status + (i * 2)) % 4;
                int nx1 = cur.x1 + dx[dir];
                int ny1 = cur.y1 + dy[dir];
                int nx2 = cur.x2 + dx[dir];
                int ny2 = cur.y2 + dy[dir];
                int nStatus = cur.status == 1 ? 0 : 1;

                if (!isCheck(nx1, ny1, nx2, ny2)) continue;

                Node node1 = new Node(nx1, ny1, cur.x1, cur.y1, nStatus, cur.cnt + 1);
                if (!set.contains(node1)) {
                    set.add(node1);
                    queue.add(node1);
                }
                Node node2 = new Node(nx2, ny2, cur.x2, cur.y2, nStatus, cur.cnt + 1);
                if (!set.contains(node2)) {
                    set.add(node2);
                    queue.add(node2);
                }
            }
        }

        return answer;
    }

    boolean isCheck(int x1, int y1, int x2, int y2) {
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return false;
        if (x1 >= n || y1 >= n || x2 >= n || y2 >= n) return false;
        if (board[x1][y1] == 1 || board[x2][y2] == 1) return false;
        return true;
    }

    class Node {
        int x1, y1, x2, y2, status, cnt;

        public Node(int x1, int y1, int x2, int y2, int status, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.status = status;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x1 == node.x1 &&
                    y1 == node.y1 &&
                    x2 == node.x2 &&
                    y2 == node.y2 &&
                    status == node.status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2, status);
        }
    }
}
