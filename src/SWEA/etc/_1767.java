package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 프로세서 연결하기
public class _1767 {
    static int n, lang, max, res;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] visit;
    static int[][] org;
    static ArrayList<Node> list;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            org = new int[n][n];
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    org[i][j] = tmp;

                    if (tmp == 1 && i != 0 && j != 0 && i != n - 1 && j != n - 1) {
                        list.add(new Node(i, j));
                    }
                }
            }

            max = 0;
            res = Integer.MAX_VALUE;
            lang = list.size();
            visit = new int[lang];
            solve(0, 0);
            sb.append(String.format("#%d %d\n", tc, res));
        }
        System.out.print(sb.toString());
    }

    private static void solve(int idx, int conn) {
        if (max > lang - idx + conn) return;
        if (idx == lang) {
            if (max < conn) {
                max = conn;
                res = Integer.MAX_VALUE;
            }

            int[][] tmp = new int[n][n];
            int cnt = 0;
            for (int i = 0; i < lang; i++) {
                if (visit[i] == -1) continue;
                Node node = list.get(i);
                int nx = node.x;
                int ny = node.y;

                while (true) {
                    nx += dx[visit[i]];
                    ny += dy[visit[i]];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                    if (org[nx][ny] == 1 || tmp[nx][ny] != 0) return;
                    tmp[nx][ny] = 1;
                    cnt++;
                }
            }

            res = Math.min(res, cnt);
            return;
        }

        Node node = list.get(idx);
        for (int i = 0; i < 4; i++) {
            int nx = node.x;
            int ny = node.y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    visit[idx] = i;
                    solve(idx + 1, conn + 1);
                    break;
                }
                if (org[nx][ny] == 1) break;
            }
        }
        visit[idx] = -1;
        solve(idx + 1, conn);
    }
}