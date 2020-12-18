package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12100 {
    static int n;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, board);
        System.out.println(max);
    }

    private static void solution(int cnt, int[][] board) {
        if (cnt == 5){
            findMax(board);
            return;
        }
        solution(cnt+1 , left(board));
        solution(cnt+1 , right(board));
        solution(cnt+1 , up(board));
        solution(cnt+1 , down(board));

    }

    private static int[][] left(int[][] board) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            int empty = 0;
            int val = -1;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                } else if (val == -1) {
                    val = board[i][j];
                } else if (val == board[i][j]) {
                    result[i][empty++] = val * 2;
                    max = Math.max(max, val *2);
                    val = -1;
                } else if (val != board[i][j]) {
                    result[i][empty++] = val;
                    val = board[i][j];
                }
                if (j == n - 1 && val != -1) {
                    result[i][empty] = val;
                }
            }
        }
        return result;
    }

    private static int[][] right(int[][] board) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            int empty = n-1;
            int val = -1;
            for (int j = n-1; j >= 0; j--) {
                max = Math.max(max, board[i][j]);
                if (board[i][j] == 0) {
                } else if (val == -1) {
                    val = board[i][j];
                } else if (val == board[i][j]) {
                    result[i][empty--] = val * 2;
                    max = Math.max(max, val *2);
                    val = -1;
                } else if (val != board[i][j]) {
                    result[i][empty--] = val;
                    val = board[i][j];
                }
                if (j == 0 && val != -1) {
                    result[i][empty] = val;
                }
            }
        }
        return result;
    }
    private static int[][] up(int[][] board) {
        int[][] result = new int[n][n];
        for (int j = 0; j < n; j++) {
            int empty = 0;
            int val = -1;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, board[i][j]);
                if (board[i][j] == 0) {
                } else if (val == -1) {
                    val = board[i][j];
                } else if (val == board[i][j]) {
                    result[empty++][j] = val * 2;
                    max = Math.max(max, val *2);
                    val = -1;
                } else if (val != board[i][j]) {
                    result[empty++][j] = val;
                    val = board[i][j];
                }
                if (i == n - 1 && val != -1) {
                    result[empty][j] = val;
                }
            }
        }
        return result;
    }
    private static int[][] down(int[][] board) {
        int[][] result = new int[n][n];
        for (int j = 0; j < n; j++) {
            int empty = n-1;
            int val = -1;
            for (int i = n-1; i >= 0; i--) {
                max = Math.max(max, board[i][j]);
                if (board[i][j] == 0) {
                } else if (val == -1) {
                    val = board[i][j];
                } else if (val == board[i][j]) {
                    result[empty--][j] = val * 2;
                    max = Math.max(max, val *2);
                    val = -1;
                } else if (val != board[i][j]) {
                    result[empty--][j] = val;
                    val = board[i][j];
                }
                if (i == 0 && val != -1) {
                    result[empty][j] = val;
                }
            }
        }
        return result;
    }

    private static int findMax(int[][] board) {
        for (int[] x : board) {
            for (int y : x) {
                max = Math.max(max, y);
            }
        }
        return max;
    }

    private static void print(int[][] board) {
        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
