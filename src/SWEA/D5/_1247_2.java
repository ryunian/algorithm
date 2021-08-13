package SWEA.D5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 최적경로
public class _1247_2 {
    static int res, INF = 987654321;
    static Point start, end;
    static List<Point> list;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            list = new ArrayList<>();

            start = new Point(sc.nextInt(), sc.nextInt());
            end = new Point(sc.nextInt(), sc.nextInt());
            for (int i = 0; i < n; i++) {
                list.add(new Point(sc.nextInt(), sc.nextInt()));
            }
            visit = new boolean[list.size()];
            res = INF;
            solve(0, 0, start);
            sb.append(String.format("#%d %d\n", tc, res));
        }
        System.out.print(sb.toString());
    }

    private static void solve(int cnt, int sum, Point prev) {
        if (sum > res) return;
        if (cnt == list.size()) {
            sum += getDistance(prev, end);
            res = Math.min(sum, res);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                int nSum = getDistance(prev, list.get(i)) + sum;
                solve(cnt + 1, nSum, list.get(i));
                visit[i] = false;
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int getDistance(Point prev, Point next) {
        int a = Math.abs(prev.x - next.x);
        int b = Math.abs(prev.y - next.y);
        return a + b;
    }
}
