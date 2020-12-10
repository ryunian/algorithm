package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String[] x = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int y = Integer.parseInt(x[j-1]);
                map[i][j] =  y + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
            }
        }

//        System.out.println();
//        for(int[] x : map){
//            for(int y : x){
//                System.out.print(y + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < m; i++) {
            String[] x = br.readLine().split(" ");
            int a = Integer.parseInt(x[0]);
            int b = Integer.parseInt(x[1]);
            int c = Integer.parseInt(x[2]);
            int d = Integer.parseInt(x[3]);
            int result = map[c][d] + map[a-1][b-1] - map[c][b-1] - map[a-1][d];
            System.out.println(result);
        }
    }
}
