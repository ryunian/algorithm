package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15684 {
    static boolean finish;
    static int n, m, h, res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[a][b + 1] = -1;
        }

        // 가로선을 놓을 개수
        for (int i = 0; i <= 3; i++) {
            res = i;
            solve(1, 0);
            if (finish) break;
        }
        System.out.println(finish ? res : -1);
    }

    private static void solve(int x, int cnt) {
        // 이미 정답이 나왔으므로 종료
        if (finish) return;

        // 가로선을 높을수 있는횟수가 최대치일떄
        if (res == cnt) {
            // 각 지점이 시작한 지점과 끝나는 지점이 같은지 체크
            if (check()) finish = true;
            return;
        }

        for (int i = x; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                // 새롭게 가로선을 추가 할 수 있을 경우
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = -1;
                    solve(i, cnt + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    // 각 지점이 시작한지점과 끝나는지점이 같은지 체크
    private static boolean check() {
        for (int i = 1; i < n; i++) {
            int x = 1, y = i;
            while (x <= h) {
                // y값을 오른쪽으로 이동
                if (map[x][y] == 1) {
                    y++;
                }
                // y값을 왼쪽으로 이동
                else if (map[x][y] == -1) {
                    y--;
                }
                // 아래로 이동
                x++;
            }
            // 시작한 지점이랑 끝나는 지점에서 같은 라인에 있지 않으면 false
            if (y != i) return false;
        }

        return true;
    }
}
