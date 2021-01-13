package JongManBook.Greedy;

import java.util.Scanner;

public class BOARDCOVER {
    private static int[][][] block = {
            {{0, 0}, {0, 1}, {1, 0}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {1, 1}}
    }; // ┌ ┐ ┘ └


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[][] board = new int[x][y];

            for (int i = 0; i < x; i++) {
                char[] arr = sc.next().toCharArray();
                for (int j = 0; j < y; j++) {
                    if (arr[j] == '#') {
                        board[i][j] = 1;
                    }
                }
            }

            int result = solve(board);
            System.out.println(result);
        }
    }

    private static int solve(int[][] board) {
        int x = -1, y = -1;
        loop:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    break loop;
                }
            }
        }
        // board가 전부 채워졌을 경우 반환
        if (x == -1) return 1;

        int ret = 0;
        for (int type = 0; type < 4; type++) {
            if (set(board, type, x, y, 1)) {
                ret += solve(board);
            }
            // 원래 상태로 변환
            set(board, type, x, y, -1);
        }

        return ret;
    }

    private static boolean set(int[][] board, int type, int x, int y, int delta) {
        boolean ok = true;
        for (int i = 0; i < 3; i++) {
            int nx = x + block[type][i][0];
            int ny = y + block[type][i][1];

            // 보드 밖으로 나갔을 경우
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) ok = false;

            // delta값을 더한 값이 2일경우 검은칸 위에 덫칠한것
            else if ((board[nx][ny] += delta) > 1) {
                ok = false;
            }
        }
        return ok;
    }
}
