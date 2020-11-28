package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
    static int n,m,v;
    static boolean[] check;
    static boolean[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new boolean[n+1][n+1];
        check = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = true;
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb.toString());
    }

    private static void dfs(int num){
        check[num] = true;
        sb.append(num).append(" ");

        for (int i = 1; i <= n; i++) {
            if(arr[num][i] && !check[i]){
                dfs(i);
            }
        }
    }

    private static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(num);
        check[num] = false;
        sb.append(num).append(" ");

        int x;
        while(!queue.isEmpty()){
            x = queue.poll();
            for (int i = 1; i <=n; i++) {
                if(arr[x][i] && check[i]){
                    queue.add(i);
                    check[i] = false;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
