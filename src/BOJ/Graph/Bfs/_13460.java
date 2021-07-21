package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13460 {
    static char[][] board;
    static int holeX, holeY, redX, redY, blueX, blueY;
    static boolean[][][][] visit;
    static int result = Integer.MAX_VALUE;
    // 좌 우 상 하
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 가로
        int n = Integer.parseInt(st.nextToken());
        // 세로
        int m = Integer.parseInt(st.nextToken());
        // 보드
        board = new char[n][m];
        visit = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            char[] y = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                char x = y[j];
                board[i][j] = x;
                if (x == 'R') {
                    redX = i;
                    redY = j;
                } else if (x == 'B') {
                    blueX = i;
                    blueY = j;
                } else if (x == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }
        bfs(redX, redY, blueX, blueY);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void bfs(int redX, int redY, int blueX, int blueY) {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(redX, redY, blueX, blueY, 0));
        visit[redX][redY][blueX][blueY] = true;

        while (!queue.isEmpty()) {
            Marble cur = queue.poll();

            if (cur.redX == holeX && cur.redY == holeY) {
                result = Math.min(result, cur.cnt);
                return;
            }
            if (cur.cnt >= 11) return;

            for (int i = 0; i < 4; i++) {
                Marble next = move(cur, i);
                if (next.blueX == holeX && next.blueY == holeY) continue;
                if (!visit[next.redX][next.redY][next.blueX][next.blueY]) {
                    visit[next.redX][next.redY][next.blueX][next.blueY] = true;
                    queue.add(next);
                }
            }
        }
    }

    private static Marble move(Marble marble, int i) {
        int rx = marble.redX;
        int ry = marble.redY;
        int bx = marble.blueX;
        int by = marble.blueY;
        int cnt = marble.cnt + 1;

        // 빨강
        while (board[rx + dx[i]][ry + dy[i]] != '#') {
            rx += dx[i];
            ry += dy[i];
            if (board[rx][ry] == 'O') break;
        }
        // 파랑
        boolean noFix = false;
        while (board[bx + dx[i]][by + dy[i]] != '#') {
            bx += dx[i];
            by += dy[i];
            if (board[bx][by] == 'O') {
                noFix = true;
                break;
            }
        }
        if (rx == bx && ry == by && !noFix) {
            if (i == 0) {
                ry = marble.redY < marble.blueY ? ry : ry + 1;
                by = marble.redY < marble.blueY ? by + 1 : by;
            } else if (i == 1) {
                ry = marble.redY < marble.blueY ? ry - 1 : ry;
                by = marble.redY < marble.blueY ? by : by - 1;
            } else if (i == 2) {
                rx = marble.redX < marble.blueX ? rx : rx + 1;
                bx = marble.redX < marble.blueX ? bx + 1 : bx;
            } else if (i == 3) {
                rx = marble.redX < marble.blueX ? rx - 1 : rx;
                bx = marble.redX < marble.blueX ? bx : bx - 1;
            }

        }
        return new Marble(rx, ry, bx, by, cnt);
    }

    private static class Marble {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;

        public Marble(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }
}

