package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17780 {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static List<Chessboard> list;

    private static class Chessboard {
        int x;
        int y;
        Deque<Node> deque;

        public Chessboard(int x, int y, int c, int idx) {
            this.x = x;
            this.y = y;
            deque = new LinkedList<>();
            deque.add(new Node(idx, c));
        }
    }

    private static class Node {
        int idx;
        int dir;

        public Node(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][n + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;
            list.add(new Chessboard(a, b, c, i));
        }

        int turn = 0;
        while (!isFind && turn < 1000) {
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).deque.getFirst().idx == i) {
                        Chessboard cur = list.get(j);
                        int nx = cur.x + dx[cur.deque.getFirst().dir];
                        int ny = cur.y + dy[cur.deque.getFirst().dir];
                        if (nx <= 0 || ny <= 0 || nx > n || ny > n || board[nx][ny] == 2) {
                            // blue
                            int x = cur.deque.getFirst().dir;
                            x += x % 2 == 0 ? 1 : 3;
                            x %= 4;
                            list.get(j).deque.getFirst().dir = x;
                            nx = cur.x + dx[x];
                            ny = cur.y + dy[x];
                            if (nx <= 0 || ny <= 0 || nx > n || ny > n || board[nx][ny] == 2) break;
                        }
                        // 흰색 , 빨간색
                        if (board[nx][ny] == 0) {
                            white(j, nx, ny);
                        } else if (board[nx][ny] == 1) {
                            red(j, nx, ny);
                        }
                        break;
                    }
                }
            }
            turn++;
        }
        System.out.println(turn == 1000 ? -1 : turn);
    }

    private static boolean isFind = false;

    private static void white(int idx, int nx, int ny) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x == nx && list.get(i).y == ny) {
                list.get(i).deque.addAll(list.get(idx).deque);
                if (list.get(i).deque.size() >= 4) {
                    isFind = true;
                }
                list.remove(idx);
                return;
            }
        }
        list.get(idx).x = nx;
        list.get(idx).y = ny;
    }

    private static void red(int idx, int nx, int ny) {
        Collections.reverse((List<?>) list.get(idx).deque);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x == nx && list.get(i).y == ny) {
                list.get(i).deque.addAll(list.get(idx).deque);
                if (list.get(i).deque.size() >= 4) {
                    isFind = true;
                }
                list.remove(idx);
                return;
            }
        }
        list.get(idx).x = nx;
        list.get(idx).y = ny;
    }
}