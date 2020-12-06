package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012 {
    // a : 가로길이,    b : 세로길이,   c : 배추의 개수
    static int a, b, c;
    static int[][] map;
    static boolean[][] visit;
    static int[][] pos = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int k = 0; k < n; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int[b][a];
            visit = new boolean[b][a];
            for (int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    if(!visit[i][j] && map[i][j] == 1){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visit[i][j] = true;
        while(!queue.isEmpty()){
            int[] value = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = value[0] + pos[k][0];
                int y = value[1] + pos[k][1];
                if(x < 0 || y < 0 || x >= b || y >= a)continue;

                if(!visit[x][y] && map[x][y] == 1){
                    visit[x][y] = true;
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
    /*private static void mapPrint(){
        for(int[] x : map){
            for(int y : x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }*/

    /*private static void visitPrint(){
        for(boolean[] x : visit){
            for(boolean y : x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }*/
}
