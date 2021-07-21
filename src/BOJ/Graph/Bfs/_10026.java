package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10026 {
    static int n, cnt1, cnt2;
    static char[][] map;
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String x = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = x.charAt(j);
            }
        }

//        for (char[] x : map) {
//            for (char y : x) {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }
        boolean[][] rgbCheck = new boolean[n][n];
        boolean[][] rbCheck = new boolean[n][n];

        cnt1 = cnt2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                RGB(rgbCheck, i, j);
                RB(rbCheck, i, j);
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    private static void RGB(boolean[][] check, int i, int j) {
        if (check[i][j]) {
            return;
        }
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{i, j});
        check[i][j] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = val[0] + pos[k][0];
                int nj = val[1] + pos[k][1];
                if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;
                if (!check[ni][nj] && map[i][j] == map[ni][nj]) {
                    queue.add(new int[]{ni, nj});
                    check[ni][nj] = true;
                }
            }
        }
        cnt1++;
    }

    private static void RB(boolean[][] check, int i, int j) {
        if (check[i][j]) {
            return;
        }
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{i, j});
        check[i][j] = true;

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = val[0] + pos[k][0];
                int nj = val[1] + pos[k][1];
                if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;
                boolean RorB = map[i][j] == 'R' && map[ni][nj] == 'G';
                boolean BorR = map[i][j] == 'G' && map[ni][nj] == 'R';
                if (!check[ni][nj] && (map[i][j] == map[ni][nj] || RorB || BorR)) {
                    queue.add(new int[]{ni, nj});
                    check[ni][nj] = true;
                }
            }
        }
        cnt2++;
    }
}
