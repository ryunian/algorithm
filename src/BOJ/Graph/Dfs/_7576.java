package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
    static int[][] map;
    static boolean[][] check;
    static int[][] pos = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        map = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if(k == 1) queue.add(new int[]{i,j});
            }
        }

        int time = dfs(queue);
        boolean fail = false;

        for(int[] a : map){
            for(int b : a){
                if(b == 0) fail = true;
//                System.out.print(b+ " ");
            }
//            System.out.println();
        }

        if(fail){
            System.out.println(-1);
        }else{
            System.out.println(time > 0 ? time - 1 : 0);
        }
    }
    private static int dfs(Queue<int[]> queue){
        int max = 0;
        while(!queue.isEmpty()){
            int[] value = queue.poll();
            for(int[] p : pos){
                int newA = p[0] + value[0];
                int newB = p[1] + value[1];
                if(newA == - 1 || newB  == -1 || newA == n || newB == m){
                    continue;
                }
                if(map[newA][newB] == 0 && !check[newA][newB]){
                    check[newA][newB] = true;
                    queue.add(new int[]{newA, newB});
                    map[newA][newB] = map[value[0]][value[1]] +1;
                    max = Math.max(max, map[newA][newB]);
                }
            }
        }
        return max;
    }
}
