package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20057 {
    static int n, res;
    static int[][] arr;
    // 좌 하 우 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int percent[] = {1, 1, 2, 2, 5, 7, 7, 10, 10};
    static int movex[][] = {
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, //좌
            {0, 0, 1, 1, 3, 1, 1, 2, 2, 2}, //하
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, //우
            {0, 0, -1, -1, -3, -1, -1, -2, -2, -2} //상
    };
    static int movey[][] = {
            {0, 0, -1, -1, -3, -1, -1, -2, -2, -2}, //좌
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, //하
            {0, 0, 1, 1, 3, 1, 1, 2, 2, 2}, //우
            {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0} //상
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(n / 2, n / 2, 0, 0, 2);
        System.out.println(res);
    }

    private static void solve(int x, int y, int dir, int cnt, int loop) {
        if (x == 0 && y == 0) {
            return;
        }
        if (cnt == loop / 2) {
            cnt = 0;
            dir = (dir + 1) % 4;
            loop++;
        }
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (arr[nx][ny] != 0) {
            int org = arr[nx][ny];
            arr[nx][ny] = 0;
            blow(org, x, y, dir);
        }

        solve(nx, ny, dir, cnt + 1, loop);
    }

    private static void blow(int sand, int x, int y, int dir) {
        int out = 0;
        for (int i = 0; i < 9; i++) {
            int nx = x + movex[dir][i];
            int ny = y + movey[dir][i];
            int val = (int) (sand * ((double) percent[i] / 100));

            out += val;
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                res += val;
                continue;
            }
            arr[nx][ny] += val;
        }
        int nx = x + movex[dir][9];
        int ny = y + movey[dir][9];
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            res += sand - out;
        } else {

            arr[nx][ny] += sand - out;
        }
    }
}
