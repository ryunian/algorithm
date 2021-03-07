package programmers.Lv3;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        자물쇠와열쇠 test = new 자물쇠와열쇠();


        test.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
        test.solution(new int[][]{{0, 0}, {1, 0}},
                new int[][]{{1, 1}, {1, 0}});
    }

    public boolean answer;
    public int n;
    public boolean[][][] visit;
    // 우, 하, 좌, 상
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    public boolean solution(int[][] key, int[][] lock) {
        answer = false;
        n = lock.length;
        visit = new boolean[n * 3][n * 3][4];
        visit[n * 3 / 2][n * 3 / 2][0] = true;
        // 방문체크와 key와 lock의 크기를 통일시키기 위해 크기 확장
        int[][] nKey = new int[n * 3][n * 3];
        int[][] nLock = new int[n * 3][n * 3];

        for (int i = n; i < n * 3; i++) {
            for (int j = n; j < n * 3; j++) {
                if (i - n < key.length && j - n < key.length) {
                    nKey[i][j] = key[i - n][j - n];
                }
                if (i - n < lock.length && j - n < lock.length) {
                    nLock[i][j] = lock[i - n][j - n];
                }
            }
        }

        solve(nKey, nLock, 0, n * 3 / 2, n * 3 / 2);
//        System.out.println(answer);
        return answer;
    }

    public void solve(int[][] key, int[][] lock, int rotateNum, int x, int y) {
        // 이미 정답이 나왔으므로 return
        if (answer) return;

        boolean check = true;
        int cntLock = 0;
        int cntKey = 0;
        for (int i = n; i < n + n; i++) {
            for (int j = n; j < n + n; j++) {
                if (key[i][j] == lock[i][j]) {
                    check = false;
                }
                if (key[i][j] == 1) cntKey++;
                if (lock[i][j] == 0) cntLock++;
            }
        }
        if (check) {
            answer = true;
            return;
        }
        // 자물쇠보다 열쇠가 작으면 소용없으로 종료
        if (cntKey < cntLock) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            // move
            if (i == 0) {
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (visit[nx][ny][rotateNum]) continue;
                    visit[nx][ny][rotateNum] = true;
                    int[][] next = move(key, j);
                    solve(next, lock, rotateNum, nx, ny);
                }
            }
            // rotate
            else {
                for (int j = rotateNum + 1; j < 4; j++) {
                    int nx = y;
                    int ny = n * 3 - 1 - x;
                    if (visit[nx][ny][j]) continue;
                    visit[nx][ny][j] = true;
                    int[][] next = rotate(key);
                    solve(next, lock, j, nx, ny);
                }
            }
        }
    }

    // 회전
    public int[][] rotate(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[n - 1 - j][i];
            }
        }
        return tmp;
    }


    // 이동
    public int[][] move(int[][] arr, int direction) {
        int n = arr.length;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                int nx = i + dx[direction];
                int ny = j + dy[direction];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                tmp[nx][ny] = arr[i][j];
            }
        }
        return tmp;
    }
}
