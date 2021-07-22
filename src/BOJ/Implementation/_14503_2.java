package BOJ.Implementation;

import java.util.Scanner;

public class _14503_2 {
    public static int n, m, startX, startY, dir, cnt;
    // 북 동 남 서
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] arr;

    public static void main(String[] args){
        // BufferedReader 를 사용시 시간 92ms 이 걸리나 Scanner 사용시 176ms 가 걸린다.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        startX = sc.nextInt();
        startY = sc.nextInt();
        dir = sc.nextInt(); // 방향
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Run
        // 재귀를 돌려보고 싶으면 solve 주석을 해제하고 solve2 는 주석처리해주세요

        // 재귀
//        solve(startX, startY, dir);

        // while문
        solve2();

        // 디버깅용 print() 함수 , 다른 함수내에서도 사용해보세요
//         print();

        // 청소하는 칸의 갯수
        System.out.println(cnt);
    }

    // while문 버전
    private static void solve2() {
        int x = startX;
        int y = startY;
        while (true){
            // 1. 현재위치를 청소한다.
            if (arr[x][y] == 0) {
                arr[x][y] = -1; // 2-c 로직상 청소한곳을 1,0 아닌것으로 처리하도록 해야함
                cnt++;
            }
            // 2. 방향을 왼쪽으로 바꾼다.
            int ndir = (dir + 3) % 4; // ndir = 새로운 방향 (new Direction)
            int nx = x + dx[ndir];
            int ny = y + dy[ndir];

            // 2-a
            if (arr[nx][ny] == 0) {
                x = nx ; y = ny; dir = ndir;
                continue;
            }
            // 2-c
            else if (isPossible(x, y)) {
                x = x + dx[(dir + 2) % 4];
                y = y + dy[(dir + 2) % 4];

                // 2-c
                if (arr[x][y] != 1) {
                    continue;
                }else {
                    // 2-d
                    break;
                }
            }
            // 2-b
            else if (arr[nx][ny] != 0) {
                dir = ndir;
                continue;
            }
        }
    }

    // 재귀버전
    public static void solve(int x, int y, int dir) {
        // 1. 현재위치를 청소한다.
        if (arr[x][y] == 0) {
            arr[x][y] = -1; // 2-c 로직상 청소한곳을 1,0 아닌것으로 처리하도록 해야함
            cnt++;
        }
        // 2. 방향을 왼쪽으로 바꾼다.
        int ndir = (dir + 3) % 4; // ndir = 새로운 방향 (new Direction)
        int nx = x + dx[ndir];
        int ny = y + dy[ndir];

        // 2-a
        if (arr[nx][ny] == 0) {
            solve(nx, ny, ndir);
        }
        // 2-c , 로직상 2-b 보다 먼저 실행시켜야 함
        else if (isPossible(x, y)) {
            x = x + dx[(dir + 2) % 4];
            y = y + dy[(dir + 2) % 4];

            // 2-c
            if (arr[x][y] != 1) {
                solve(x, y, dir);
            }
        }
        // 2-b
        else if (arr[nx][ny] != 0) {
            solve(x, y, ndir);
        }
        // 2-d 종료
    }

    // 주변이 '청소' 되어있거나 '벽'인 경우를 체크하는 메소드
    // 함수이름은 귀찬아서... , 보통 boolean 값을 반환하는 함수의 이름은 is~~~ 으로 작성함
    public static boolean isPossible(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (arr[nx][ny] == 0) return false;
        }
        return true;
    }

    // 디버깅용 프린트함수
    public static void print(){
        for(int[] x : arr){
            for(int y : x){
                System.out.printf("%2d ", y);
            }
            System.out.println();
        }
        System.out.println();
    }
}

