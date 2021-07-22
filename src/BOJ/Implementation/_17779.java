package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17779 {
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = Integer.MAX_VALUE;
        for (int d1 = 1; d1 <= n; d1++) {
            for (int d2 = 1; d2 <= n; d2++) {
                for (int x = 1; x + d1 + d2 <= n; x++) {
                    for (int y = 1; y + d2 <= n; y++) {
                        if (y - d1 >= y || 1 > y - d1) continue;
                        res = Math.min(solve(x, y, d1, d2), res);
                    }
                }
            }
        }
        System.out.println(res);

    }

    private static int solve(int x, int y, int d1, int d2) {
        int[][] tmp = new int[n + 1][n + 1];
        // 경계선을 나눈다.
        fillBoundary(x, y, d1, d2, tmp);
        // 1~4번 선거구를 나눈다.
        fillEtc(x, y, d1, d2, tmp);
        // 계산
        return cal(tmp);
    }

    private static int cal(int[][] tmp) {
        int[] cnt = new int[5 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int idx = tmp[i][j] == 0 ? 5 : tmp[i][j];
                cnt[idx] += arr[i][j];
            }
        }
        Arrays.sort(cnt);
        return cnt[5] - cnt[1];
    }

    // 1,3번 선거구는 왼쪽쪽부터 2,4번 선거구는 오른쪽부터 채워야한다.
    private static void fillEtc(int x, int y, int d1, int d2, int[][] tmp) {
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (tmp[i][j] == 5) break;
                tmp[i][j] = 1;
            }
        }
        for (int i = 1; i <= x + d2; i++) {
            for (int j = n; j > y; j--) {
                if (tmp[i][j] == 5) break;
                tmp[i][j] = 2;
            }
        }
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if (tmp[i][j] == 5) break;
                tmp[i][j] = 3;
            }
        }
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j = n; j >= y - d1 + d2; j--) {
                if (tmp[i][j] == 5) break;
                tmp[i][j] = 4;
            }
        }
    }

    private static void fillBoundary(int x, int y, int d1, int d2, int[][] tmp) {
        for (int i = x, j = y; i <= x + d1; i++, j--) {
            tmp[i][j] = 5;
        }
        for (int i = x, j = y; i <= x + d2; i++, j++) {
            tmp[i][j] = 5;
        }
        for (int i = x + d1, j = y - d1; i <= x + d1 + d2; i++, j++) {
            tmp[i][j] = 5;
        }
        for (int i = x + d2, j = y + d2; i <= x + d2 + d1; i++, j--) {
            tmp[i][j] = 5;
        }
    }
}