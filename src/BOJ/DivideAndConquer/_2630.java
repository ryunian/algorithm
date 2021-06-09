package BOJ.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2630 {
    static int[][] map;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0, n);

//        for (int[] x : map) {
//            for (int y : x) {
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }
        System.out.println(white);
        System.out.println(blue);
    }

    private static void solve(int x, int y, int size) {
        int color = map[x][y];
        boolean more = false; // 더나뉘는지 유무
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(color != map[i][j]) {
                    more = true; // 색깔다르니까 나눠
                    break;
                }
            }
        }
        if(!more || size == 1){
            calcul(map[x][y]);
            return;
        }


        int divSize = size / 2;
        solve(x, y, divSize);
        solve(x, y + divSize, divSize);
        solve(x + divSize, y, divSize);
        solve(x + divSize, y + divSize, divSize);
    }
    static void calcul(int val){
        if(val == 1){
            blue++;
        }else {
            white++;
        }
    }
}
