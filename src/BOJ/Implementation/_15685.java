package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15685 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] map;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new boolean[101][101];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            int way = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            solve(way, age);
        }
        int res = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void solve(int way, int age) {
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(way);
        x = x + dx[way];
        y = y + dy[way];

        if (!check(x, y)) return;
        map[x][y] = true;

        for (int i = 1; i <= age; i++) {
            dragonCurve(tmp);
        }
    }

    private static void dragonCurve(ArrayList<Integer> tmp) {
        for (int i = tmp.size() - 1; i >= 0; i--) {
            int next = (tmp.get(i) + 1) % 4;
            x = x + dx[next];
            y = y + dy[next];
            if (!check(x, y)) continue;

            tmp.add(next);
            map[x][y] = true;
        }
    }

    private static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > 100 || y > 100) return false;
        return true;
    }
}
