package BOJ.Graph.Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178 {
    static int n, m;
    static int[][] pos = {{0, 1}, {1, 0}, {-1, 0},{0,-1}};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            char[] x = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = x[j-1] - '0';
            }
        }

        bfs(1, 1);
        System.out.println(arr[n][m]+1);
//        for(int[] x : arr){
//            for(int y : x){
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }
    }

    private static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a,b});
        arr[a][b] = 0;

        while(!queue.isEmpty()){
            int[] x = queue.poll();
            for (int i = 0; i < 4; i++) {
                int a2 = x[0]+ pos[i][0];
                int b2 = x[1]+ pos[i][1];
                if(arr[a2][b2] == 1){
                    queue.add(new int[]{a2,b2});
                    arr[a2][b2] = arr[x[0]][x[1]]+1;
                }
            }
        }
    }
}
