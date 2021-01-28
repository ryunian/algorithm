package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389 {
    static int n, m, INF = 987654321;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = map[b][a] = 1;
        }


//        solve();
        solve2();
    }

    private static void solve2() {
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            int sum = bfs(i);
            if(min > sum){
                min = sum;
                res = i+1;
            }
        }
        System.out.println(res);
    }

    private static int bfs(int root) {
        int[] visit = new int[n];
        Arrays.fill(visit, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visit[root] = 0;
        int cnt = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            cnt += visit[cur];
            for (int next = 0; next < n; next++) {
                if(visit[next] == -1 && map[cur][next] == 1){
                    visit[next] = visit[cur] +1;
                    queue.add(next);
                }
            }
        }
        return cnt;
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && map[i][j] != 1) map[i][j] = INF;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
            if (sum < min) {
                min = sum;
                res = i + 1;
            }
        }
        System.out.println(res);
    }

}

