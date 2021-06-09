package BOJ.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1780 {
    static int[] res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = new int[3];
        solve(0, 0, n);

        for(int x : res){
            System.out.println(x);
        }
    }

    private static void solve(int x, int y, int size) {

        int flag = map[x][y];
        boolean isPossible = true;
        for (int i = x; i < x +size; i++) {
            for (int j = y; j < y + size; j++) {
                if(flag != map[i][j]){
                    isPossible = false;
                    break;
                }
            }
        }

        if(isPossible){
            res[flag+1]++;
            return;
        }

        int div = size / 3;
        solve(x, y, div);
        solve(x, y + div, div);
        solve(x, y + div + div, div);

        solve(x + div, y, div);
        solve(x + div, y + div, div);
        solve(x + div, y + div + div, div);

        solve(x + div + div, y, div);
        solve(x + div + div, y + div, div);
        solve(x + div + div, y + div + div, div);
    }
}
