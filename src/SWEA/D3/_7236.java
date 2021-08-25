package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 저수지의 물의 총 깊이 구하기
public class _7236 {
    static int n;
    static String[][] arr;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, 1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());

            arr = new String[n][n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().split(" ");
            }

            System.out.printf("#%d %d\n", tc, solve());
        }
    }

    private static int solve() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(arr[nx][ny].equals("W")) cnt++;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}
