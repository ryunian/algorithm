package programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    public static void main(String[] args) {
        거리두기확인하기 test = new 거리두기확인하기();
        test.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }

    char[][] arr;
    boolean[][] visit;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        arr = new char[5][5];

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < 5; j++) {
                arr[j] = places[i][j].toCharArray();
            }
            answer[i] = solve() ? 1 : 0;
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private boolean solve() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 'P') continue;
                if (!bfs(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visit = new boolean[5][5];
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (arr[nx][ny] == 'X' || visit[nx][ny]) continue;
                if (arr[nx][ny] == 'P') return false;

                if (cur.cnt < 1) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }
        return true;
    }

    class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
}
