package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14890 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        int[][] map2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                map2[j][i] = x;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isBuild = new boolean[n];
            boolean isPossible = true;

            boolean[] isBuild2 = new boolean[n];
            boolean isPossible2 = true;

            for (int j = 1; j < n; j++) {
                if (!check(i, j, map, isBuild)) {
                    isPossible = false;
                }
                if (!check(i, j, map2, isBuild2)) {
                    isPossible2 = false;
                }
            }
            if (isPossible) res++;
            if (isPossible2) res++;
        }
        System.out.println(res);
    }

    private static boolean check(int i, int j, int[][] map, boolean[] isBuild) {
        if (map[i][j - 1] == map[i][j] || isBuild[j]) {
            return true;
        } else {
            // 오른쪽이 더 클경우 왼쪽에 경사로를 만든다.
            if (map[i][j - 1] - map[i][j] == -1) {
                // 범위를 벗어나는 경우
                if (j - m < 0) return false;

                // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                for (int k = 1; k <= m; k++) {
                    if (map[i][j - 1] != map[i][j - k]) {
                        return false;
                    }
                }

                // 경사로를 만든다.
                for (int k = 1; k <= m; k++) {
                    if (isBuild[j - k]) return false;
                    isBuild[j - k] = true;
                }
            }
            // 왼쪽이 더 클경우 오른쪽에 경사로를 만든다.
            else if (map[i][j - 1] - map[i][j] == 1) {
                // 경사로를 놓다가 범위를 벗어나는 경우
                if (j + m - 1 >= n) return false;

                // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                for (int k = 1; k < m; k++) {
                    if (map[i][j] != map[i][j + k]) {
                        return false;
                    }
                }

                // 경사로를 만든다.
                for (int k = 0; k < m; k++) {
                    if (isBuild[j + k]) return false;
                    isBuild[j + k] = true;
                }
            }
            // 높이 차이가 1이 아닌경우
            else return false;
            return true;
        }
    }
}
