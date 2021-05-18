package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _11559 {
    private static int n = 12, m = 6;
    private static char[][] map;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solve();
    }

    private static void solve() {
        int res = 0;
        while (true){
            if(boom()){
                down();
                res++;
            }else{
                break;
            }
        }
        System.out.println(res);
    }

    private static void down() {
        for (int col = 0; col < m; col++) {
            int minDot = 0;
            for (int row = n-1; row >= 0 ; row--) {
                if(map[row][col] == '.' && minDot < row){
                    minDot = row;
                }
            }
            for (int i = minDot-1; i >= 0; i--) {
                if(map[i][col] != '.'){
                    map[minDot--][col] = map[i][col];
                    map[i][col] = '.';
                }
            }
        }
    }

    private static boolean boom() {
        boolean[][] visit = new boolean[n][m];
        boolean isPossible = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != '.' && bfs(i,j, visit)){
                    isPossible = true;
                }
            }
        }

        return isPossible;
    }

    private static boolean bfs(int x, int y, boolean[][] visit) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visit[x][y] = true;

        List<Pair> tmp = new ArrayList<>();
        tmp.add(new Pair(x,y));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visit[nx][ny] && map[x][y] == map[nx][ny]) {
                    visit[nx][ny] = true;
                    tmp.add(new Pair(nx, ny));
                    queue.add(new Pair(nx , ny));
                }
            }
        }
        if(tmp.size() >= 4){
            for(Pair pair : tmp){
                int a = pair.x;
                int b = pair.y;
                map[a][b] = '.';
            }
            return true;
        }else{
            return false;
        }

    }

    private static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print(){
        for(char[] a : map){
            for(char b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
