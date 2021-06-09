package BOJ.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        solve(0, 0, n);
        System.out.println(sb.toString());
    }

    private static void solve(int x, int y, int size) {
        int tmp = map[x][y];
        boolean isPossible = true;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (tmp != map[i][j]) {
                    isPossible = false;
                    break;
                }
            }
        }

        if (!isPossible) {
            sb.append("(");
            int div = size / 2;
            solve(x, y, div);
            solve(x, y + div, div);
            solve(x + div, y, div);
            solve(x + div, y + div, div);
            sb.append(")");
        } else {
            sb.append(tmp);
        }

    }
}
