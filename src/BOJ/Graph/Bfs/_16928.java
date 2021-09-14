package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 뱀과 사다리 게임
public class _16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[][] arr = new Node[10][10];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a / 10][a % 10] = new Node(b / 10, b % 10);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        int[][] visit = new int[10][10];
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (x == 9 && y == 9) {
                System.out.println(visit[x][y] - 1);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nx = x;
                int ny = y + i;
                if (ny >= 10) {
                    nx++;
                    ny = ny % 10;
                }
                if (nx >= 10) continue;
                if (arr[nx][ny] != null) {
                    Node node = arr[nx][ny];
                    nx = node.x;
                    ny = node.y;
                }
                if (visit[nx][ny] != 0) continue;
                visit[nx][ny] = visit[x][y] + 1;
                queue.add(new Node(nx, ny));
            }
        }

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
