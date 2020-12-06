package BOJ.DivdeAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
    static int n, m, o, size;
    static int[][] pos = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 행
        o = Integer.parseInt(st.nextToken()); // 열
        size = (int) Math.pow(2, n);

        solve(0, 0, 0, size);
    }

    private static void solve(int x, int y, int cnt, int divSize) {
        if (divSize == 2) {
            for (int i = 0; i < 4; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];
                if (nx == m && ny == o) {
                    System.out.println(cnt + i);
                    System.exit(0);
                }
            }
            return;
        }
        // 분할
        int div = divSize / 2;
        solve(x, y, cnt * 4, div);
        solve(x, y + div, cnt * 4 + 4, div);
        solve(x + div, y, cnt * 4 + 8, div);
        solve(x + div, y + div, cnt * 4 + 12, div);
    }
}
