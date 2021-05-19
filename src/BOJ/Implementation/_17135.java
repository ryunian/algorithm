package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17135 {
    private static int n, m, d, enemyCnt, res = 0;
    // 좌 상 우
    private static int[] dx = {0, -1, 0};
    private static int[] dy = {-1, 0, 1};
    private static int[] archer;
    private static int[][] map, org;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        org = new int[n][m];
        enemyCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                org[i][j] = x;
                if (x == 1) enemyCnt++;
            }
        }
        archer = new int[3];
        for (int i = 0; i < m - 2; i++) {
            archer[0] = i;
            for (int j = i + 1; j < m - 1; j++) {
                archer[1] = j;
                for (int k = j + 1; k < m; k++) {
                    archer[2] = k;
                    solve(0,0);
                }
            }
        }
        System.out.println(res);
    }

    // score : 아쳐가 죽인 적의 수
    // sub : 성에 침입한 적의 수
    private static void solve(int score, int sub) {
        if(enemyCnt == score + sub){
            res = Math.max(res, score);
            copy();
            return;
        }
        for (int i = 0; i < 3; i++) {
            bfs(i);
        }
        sub += deleteEnemyCnt();
        score += down();
        solve(score , sub);
    }

    // 깊은복사
    private static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = org[i][j];
            }
        }
    }

    // 넓이 우선 탐색을 이용하여 가장 가까운 적을 죽인다.
    private static void bfs(int idx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, archer[idx]));
        int[][] visit = new int[n+1][m];

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            // 좌 상 우 순서대로 이동한다.
            for (int i = 0; i < 3; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny] == 0 && visit[cur.x][cur.y] < d){
                    queue.add(new Pair(nx, ny));
                    visit[nx][ny] = visit[cur.x][cur.y] +1;

                    // 적이거나 적의 시체일 경우 종료
                    if(map[nx][ny] != 0){
                        map[nx][ny] = 2;
                        return;
                    }
                }
            }
        }
    }

    // 이동할경우 성에 침입할 적의 수를 반환한다.
    private static int deleteEnemyCnt(){
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if(map[n-1][i] == 1) cnt++;
        }
        return cnt;
    }

    // 적이 아래로 한칸 이동하며, 죽은 적의 수를 반환한다.
    private static int down() {
        int[][] temp = new int[n][m];
        int ret = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    temp[i +1][j] = 1;
                }else if(map[i][j] == 2){
                    ret++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(map[n-1][i] == 2) ret++;
        }
        map = temp;
        return ret;
    }


    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print(){
        for(int[] a : map){
            for(int b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
