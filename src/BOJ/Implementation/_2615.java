package BOJ.Implementation;

import java.util.Scanner;

public class _2615 {
    static int n;
    static int[] dx = {-1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = 19;
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        int x = 0, y = 0;
        loop:
        for (int k = 0; k < 4; k++) {
            visit = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] == 0 || visit[i][j]) continue;

                    visit[i][j] = true;

                    int cnt = findNumber(i, j, k, arr[i][j]) + 1;
                    int cnt2 = 0;
                    if (k == 0) {
                        cnt2 = findNumber(i, j, 4, arr[i][j]);
                    }

                    if (cnt + cnt2 == 5) {
                        if (k == 0) {
                            x = i + (dx[4] * cnt2);
                            y = j + (dy[4] * cnt2);
                        } else {
                            x = i;
                            y = j;
                        }
                        res = arr[i][j];
                        break loop;
                    }
                }
            }
        }
        if (res != 0) {
            System.out.println(res);
            System.out.println(x + " " + y);
        } else {
            System.out.println(0);
        }
    }

    static int findNumber(int x, int y, int k, int color) {
        int cnt = 0;
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[k];
            ny += dy[k];
            if (nx <= 0 || ny <= 0 || nx > n || ny > n)
                break;
            if (arr[nx][ny] == color) {
                cnt++;
                visit[nx][ny] = true;
            } else {
                break;
            }
        }
        return cnt;
    }
}
