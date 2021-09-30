package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 새로운 게임 2
public class _17837 {
    static int n, m, num = 1;
    static int[][] arr;
    static boolean isOk;
    static ArrayList<Node> list;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x, y;
        ArrayList<Chess> chess;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.chess = new ArrayList<>();
        }

        public Node(int x, int y, int idx, int dir) {
            this.x = x;
            this.y = y;
            this.chess = new ArrayList<>();
            chess.add(new Chess(idx, dir));
        }
    }

    static class Chess {
        int idx, dir;

        public Chess(int idx, int dir) {
            this.idx = idx;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            list.add(new Node(a, b, i, c));
        }

        while (true) {
            for (int i = 1; i <= m; i++) {
                loop:
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < list.get(j).chess.size(); k++) {
                        if (list.get(j).chess.get(k).idx == i) {
                            solve(j, k);
                            break loop;
                        }
                    }
                }
            }
            if (isOk) break;
            if (++num > 1000) break;
        }
        System.out.println(num > 1000 ? -1 : num);
    }

    private static void solve(int lidx, int cidx) {
        Node node = list.get(lidx);
        int dir = node.chess.get(cidx).dir;
        int nx = node.x + dx[dir];
        int ny = node.y + dy[dir];

        if (!check(nx, ny)) {
            int rdir = dir + (dir % 2 == 1 ? -1 : 1);
            node.chess.get(cidx).dir = rdir;
            nx = node.x + dx[rdir];
            ny = node.y + dy[rdir];
            if (!check(nx, ny)) return;
        }
        Node tmp;
        if (cidx == 0) {
            tmp = node;
            tmp.x = nx;
            tmp.y = ny;
            list.remove(lidx);
        } else {
            tmp = new Node(nx, ny);
            int loop = node.chess.size() - cidx;
            while (loop-- > 0) {
                tmp.chess.add(node.chess.remove(cidx));
            }
        }
        if (arr[nx][ny] == 1) {
            Collections.reverse(tmp.chess);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x == nx && list.get(i).y == ny) {
                list.get(i).chess.addAll(tmp.chess);
                if (list.get(i).chess.size() >= 4) {
                    isOk = true;
                }
                return;
            }
        }
        list.add(tmp);
    }

    private static boolean check(int x, int y) {
        if (x < 1 || y < 1 || x > n || y > n || arr[x][y] == 2) return false;
        return true;
    }
}
