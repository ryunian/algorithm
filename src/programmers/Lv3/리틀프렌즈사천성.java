package programmers.Lv3;

import java.util.*;

public class 리틀프렌즈사천성 {
    public static void main(String[] args) {
        리틀프렌즈사천성 test = new 리틀프렌즈사천성();
//        test.solution(3, 3, new String[]{"DBA", "C*A", "CDB"});
//        test.solution(2, 4, new String[]{"NRYN", "ARYA"});
//        test.solution(4, 4, new String[]{".ZI.", "M.**", "MZU.", ".IU."});
//        test.solution(2, 2, new String[]{"AB", "BA"});
        test.solution(5, 5, new String[]{"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"});
    }

    static char[][] arr;
    static Set<Character> set;
    static List<Node> list;
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public String solution(int m, int n, String[] board) {
        StringBuilder sb = new StringBuilder();
        this.m = m;
        this.n = n;
        arr = new char[m][n];
        set = new HashSet<>();
        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                arr[i][j] = c;
                if (!set.contains(c) && c != '*' && c != '.') {
                    list.add(new Node(i, j, c));
                    set.add(c);
                }
            }
        }
        list.sort(Comparator.comparing(o -> o.c));
        List<Character> res = new ArrayList<>();
        while (true) {
            int max = list.size();
            for (int i = 0; i < max; i++) {
                if (bfs(i)) {
                    res.add(list.get(i).c);
                    list.remove(i);
                    break;
                }
            }
            if (list.isEmpty()) {
                res.forEach(s -> sb.append(s));
                break;
            }
            if (max == list.size()) {
                sb.append("IMPOSSIBLE");
                break;
            }
        }
        return sb.toString();
    }

    private boolean bfs(int idx) {
        Node node = list.get(idx);
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cnt));
        queue.add(new Node(node.x, node.y, node.c, 5, 0));
        int[][] visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visit[i], 987654321);
        }
        visit[node.x][node.y] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nDir = (cur.dir + i) % 4;
                int nx = cur.x + dx[nDir];
                int ny = cur.y + dy[nDir];
                int nCnt = cur.cnt;
                if (cur.dir != 5 && nDir != cur.dir) {
                    nCnt++;
                }

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (nCnt > 1) continue;
                if (visit[nx][ny] < nCnt || arr[nx][ny] == '*') continue;

                if (arr[nx][ny] == '.') {
                    visit[nx][ny] = Math.min(visit[nx][ny], nCnt);
                    queue.add(new Node(nx, ny, cur.c, nDir, nCnt));
                } else if (arr[nx][ny] == node.c) {
                    arr[node.x][node.y] = '.';
                    arr[nx][ny] = '.';
                    return true;
                }
            }
        }
        return false;
    }

    private static class Node {
        int x;
        int y;
        char c;
        int dir;
        int cnt;

        public Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        public Node(int x, int y, char c, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    private void print() {
        for (var x : arr) {
            for (var y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
