package SWEA.D2;

import java.util.Scanner;

public class _1954 {
    // 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int tc = 1; tc <= test; tc++) {
            n = sc.nextInt();
            arr = new int[n][n];
            System.out.println("#" + tc);
            solve();
//            solve2(0, 0, 0, 0);
            print();
        }
    }

    // 반복문 버전
    private static void solve() {
        int cnt = 0;
        int dir = 0;
        int x = 0;
        int y = 0;
        while (cnt < n * n) {
            arr[x][y] = ++cnt;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (isOk(nx, ny) && arr[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }
    }

    // 재귀버전
    public static void solve2(int cnt, int x, int y, int dir) {
        // 기저조건
        if (cnt == n * n) return;
        arr[x][y] = ++cnt;

        // 다음 좌표
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (isOk(nx, ny) && arr[nx][ny] == 0) {
            solve2(cnt, nx, ny, dir);

        } else {
            // 다음좌표로 갈수 없으므로 방향을 오른쪽으로 바꾼다.
            dir = (dir + 1) % 4;
            x = x + dx[dir];
            y = y + dy[dir];
            solve2(cnt, x, y, dir);
        }
    }

    // 배열 밖으로 나갓는지 체크하는 메소드
    public static boolean isOk(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) return false;
        return true;
    }


    public static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

