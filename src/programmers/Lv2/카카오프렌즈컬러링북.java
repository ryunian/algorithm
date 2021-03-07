package programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        카카오프렌즈컬러링북 test = new 카카오프렌즈컬러링북();
        test.solution(6, 4,
                new int[][]{
                        {1, 1, 1, 0},
                        {1, 2, 2, 0},
                        {1, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 3},
                        {0, 0, 0, 3}
                });
        test.solution(13, 16,
                new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                        {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}});
    }

    static int numberOfArea;
    static int maxSizeOfOneArea;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && picture[i][j] != 0) {
                    bfs(picture[i][j], i, j, m, n, picture);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
//        System.out.println(numberOfArea+" "+maxSizeOfOneArea);
        return answer;
    }

    private void bfs(int color, int x, int y, int m, int n, int[][] picture) {
        System.out.println(x+" "+y);
        Queue<Node> queue = new LinkedList<>();
        visit[x][y] = true;
        queue.add(new Node(x, y));

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

                if (!visit[nx][ny] && picture[nx][ny] == color) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        numberOfArea++;
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
