package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// topdown은 메모리초과
public class _2096 {
    static int n, INF = 987654321;
    static int[][] min, max, map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bottomUp();
    }

    private static void bottomUp() {
        max = new int[2][3];
        min = new int[2][3];
        max[0][0] = min[0][0] = map[0][0];
        max[0][1] = min[0][1] = map[0][1];
        max[0][2] = min[0][2] = map[0][2];

        for (int i = 1; i < n; i++) {
            max[1][0] = map[i][0] + Math.max(max[0][0], max[0][1]);
            max[1][1] = map[i][1] + Math.max(Math.max(max[0][0], max[0][1]), max[0][2]);
            max[1][2] = map[i][2] + Math.max(max[0][1], max[0][2]);

            min[1][0] = map[i][0] + Math.min(min[0][0], min[0][1]);
            min[1][1] = map[i][1] + Math.min(Math.min(min[0][0], min[0][1]), min[0][2]);
            min[1][2] = map[i][2] + Math.min(min[0][1], min[0][2]);

            max[0][0] = max[1][0];
            max[0][1] = max[1][1];
            max[0][2] = max[1][2];

            min[0][0] = min[1][0];
            min[0][1] = min[1][1];
            min[0][2] = min[1][2];
        }
        StringBuilder sb = new StringBuilder();
        sb
                .append(Math.max(Math.max(max[0][0], max[0][1]), max[0][2]))
                .append(" ")
                .append(Math.min(Math.min(min[0][0], min[0][1]), min[0][2]));
        System.out.println(sb.toString());
    }

    private static int minSolve(int x, int y) {
        if (x < 0) return 0;

        int ret = min[x][y];
        if (ret != -1) return ret;
        ret = INF;
        for (int i = 0; i < 3; i++) {
            if (y + i - 1 < 0 || y + i - 1 > 2) continue;
            ret = Math.min(ret, minSolve(x - 1, y + i - 1) + map[x][y]);
        }
        return min[x][y] = ret;
    }

    private static int maxSolve(int x, int y) {
        if (x < 0) return 0;

        int ret = max[x][y];
        if (ret != -1) return ret;
        ret = 0;
        for (int i = 0; i < 3; i++) {
            if (y + i - 1 < 0 || y + i - 1 > 2) continue;
            ret = Math.max(ret, maxSolve(x - 1, y + i - 1) + map[x][y]);
        }
        return max[x][y] = ret;
    }
}
