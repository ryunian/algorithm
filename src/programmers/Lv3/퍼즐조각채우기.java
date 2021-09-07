package programmers.Lv3;

import java.util.*;

public class 퍼즐조각채우기 {
    public static void main(String[] args) {
        퍼즐조각채우기 test = new 퍼즐조각채우기();
        test.solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},
                new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}});
    }

    ArrayList<ArrayList<Pair>> list;
    boolean[][] visit;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int answer, n, m;

    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        n = game_board.length;
        m = n;
        list = new ArrayList<>();

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && table[i][j] == 1) {
                    bfs(i, j, table, 0);
                }
            }
        }

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && game_board[i][j] == 0) {
                    bfs(i, j, game_board, 1);
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    private void bfs(int x, int y, int[][] table, int flag) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visit[x][y] = true;

        ArrayList<Pair> black = new ArrayList<>();
        black.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (table[nx][ny] == flag || visit[nx][ny]) continue;
                visit[nx][ny] = true;
                black.add(new Pair(nx - x, ny - y));
                queue.add(new Pair(nx, ny));
            }
        }
        if (flag == 0) {
            list.add(black);
        } else {
            int size = black.size();
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Pair> piece = list.get(i);
                if (piece.size() != size) continue;

                for (int j = 0; j < 4; j++) {
                    Set<Pair> set = new HashSet<>();
                    for (int k = 0; k < size; k++) {
                        set.add(piece.get(k));
                        set.add(black.get(k));
                    }
                    for (int k = 0; k < size; k++) {
                        int tmp = piece.get(k).x;
                        piece.get(k).x = piece.get(k).y;
                        piece.get(k).y = tmp * -1;
                    }

                    if (set.size() == size) {
                        answer += size;
                        list.remove(i);
                        return;
                    }
                }
            }
            for (int i = 0; i < black.size(); i++) {
                visit[x + black.get(i).x][y + black.get(i).y] = false;
            }
        }
    }

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
