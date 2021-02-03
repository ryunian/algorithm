package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499 {
    static int n, m, x, y, k;
    static int[][] map;
    // 동 서 북 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = new int[7];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int a = Integer.parseInt(st.nextToken()) - 1;
            solve(a);
        }
        System.out.print(sb.toString());

    }

    private static void solve(int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
            return;
        }

        // dice[1] : 아랫면
        // dice[6] : 윗면
        // 동 서 북 남
        int[] tmp = dice.clone();
        switch (dir) {
            case 0:
                dice[1] = tmp[3];
                dice[3] = tmp[6];
                dice[4] = tmp[1];
                dice[6] = tmp[4];
                break;
            case 1:
                dice[1] = tmp[4];
                dice[3] = tmp[1];
                dice[4] = tmp[6];
                dice[6] = tmp[3];
                break;

            case 2:
                dice[1] = tmp[2];
                dice[2] = tmp[6];
                dice[5] = tmp[1];
                dice[6] = tmp[5];
                break;
            case 3:
                dice[1] = tmp[5];
                dice[2] = tmp[1];
                dice[5] = tmp[6];
                dice[6] = tmp[2];
                break;
        }
        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[1];
        } else {
            dice[1] = map[nx][ny];
            map[nx][ny] = 0;
        }
        sb.append(dice[6] + "\n");
        x = nx;
        y = ny;
    }
}
