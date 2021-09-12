package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 사탕 게임
public class _3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                check(i, j);
                check(i, j + 1);
                swap(i, j, i, j + 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j);
                check(i, j);
                check(i + 1, j);
                swap(i, j, i + 1, j);
            }
        }
        System.out.println(max);
    }

    static char[][] arr;
    static int n, max = 0;

    private static void swap(int i1, int j1, int i2, int j2) {
        char tmp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tmp;
    }

    private static void check(int x, int y) {
        int left, right;
        char c = arr[x][y];
        // 수평방향
        left = y;
        right = y;
        while (left - 1 >= 0 && arr[x][left - 1] == c) left--;
        while (right + 1 < n && arr[x][right + 1] == c) right++;
        max = Math.max(max, right - left + 1);

        // 수직방향
        left = x;
        right = x;
        while (left - 1 >= 0 && arr[left - 1][y] == c) left--;
        while (right + 1 < n && arr[right + 1][y] == c) right++;
        max = Math.max(max, right - left + 1);
    }
}
