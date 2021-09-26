package BOJ.Graph.Bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 이모티콘
public class _14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 1001;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));

        boolean[][] visit = new boolean[max + 1][max + 1];
        visit[1][0] = true;

        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (cur.x == n) {
                System.out.println(cur.cnt);
                break;
            }

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            if (visit[cur.x][cur.x] == false) {
                visit[cur.x][cur.x] = true;
                queue.add(new Node(cur.x, cur.x, cur.cnt + 1));
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            if (cur.copy != -1) {
                int nx = cur.x + cur.copy;
                if (nx > 0 && nx < max && visit[nx][cur.copy] == false) {
                    visit[nx][cur.copy] = true;
                    queue.add(new Node(nx, cur.copy, cur.cnt + 1));
                }
            }

            // 화면에 있는 이모티콘 중 하나를 삭제한다.
            int nx = cur.x - 1;
            if (nx > 0 && nx < max && visit[nx][cur.copy] == false) {
                visit[nx][cur.copy] = true;
                queue.add(new Node(nx, cur.copy, cur.cnt + 1));
            }
        }
    }

    static class Node {
        int x, copy, cnt;

        public Node(int x, int copy, int cnt) {
            this.x = x;
            this.copy = copy;
            this.cnt = cnt;
        }
    }
}
