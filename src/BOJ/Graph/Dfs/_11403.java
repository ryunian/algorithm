package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11403 {
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, new boolean[n]);
        }
        print(map);
    }
    private static void dfs(int idx, int x, boolean[] check){
        for (int i = 0; i < n; i++) {
            if(map[x][i] == 1 && !check[i]){
                check[i] = true;
                map[idx][i] = 1;
                dfs(idx, i, check);
            }
        }
    }

    private static void print(int[][] map){
        for(int[] x : map){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
