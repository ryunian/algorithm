package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

// 8.16 두니발 박사의 탈옥
public class NUMB3RS {
    static int n, day, prison, query;
    static int[] degree;
    static int[][] map;
    static double[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt(); // 마을 수
            day = sc.nextInt(); // 경과 날짜
            prison = sc.nextInt(); // 감옥위치
            map = new int[51][51]; // 산길 정보
            degree = new int[51]; // 한 마을과 연결된 마을의 수
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = sc.nextInt();
                    map[i][j] = x;
                    if (x == 1) degree[i]++;
                }
            }
            int queryNum = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while (queryNum-- > 0) {
                query = sc.nextInt();
                dp = new double[51][101];
                for (int i = 0; i < dp.length; i++) {
                    Arrays.fill(dp[i], -1);
                }
//                double res = solve(prison, 0);
                double res = solve2(query, day);


//                System.out.printf("%.8f ", res);
                sb.append(String.format("%.8f ", res));
            }
            System.out.println(sb.toString());
        }
    }

    // here : 현재위치
    // pass : 경과일
    private static double solve(int here, int pass) {
        // 기저사례 : day일이 지난 경우
        if (pass == day) return (here == query ? 1.0 : 0.0);

        double ret = dp[here][pass];
        if (ret > -0.5) return ret;

        ret = 0.0;
        for (int there = 0; there < n; there++) {
            if (map[here][there] == 1) {
                ret += solve(there, pass + 1) / degree[here];
            }
        }

        return dp[here][pass] = ret;
    }

    // 탈옥 후 days일째에 두니발 박사가 here번 마을에 숨어 있을 확률
    private static double solve2(int here, int days) {
        // 기저사례 : 0일쨰
        if (days == 0) return (here == prison ? 1.0 : 0.0);

        double ret = dp[here][days];
        if (ret > -0.5) return ret;

        ret = 0.0;
        for (int there = 0; there < n; there++) {
            if (map[here][there] == 1) {
                ret += solve2(there, days - 1) / degree[there];
            }
        }

        return dp[here][days] = ret;
    }
}
/*
2
5 2 0
0 1 1 1 0
1 0 0 0 1
1 0 0 0 0
1 0 0 0 0
0 1 0 0 0
3
0 2 4
8 2 3
0 1 1 1 0 0 0 0
1 0 0 1 0 0 0 0
1 0 0 1 0 0 0 0
1 1 1 0 1 1 0 0
0 0 0 1 0 0 1 1
0 0 0 1 0 0 0 1
0 0 0 0 1 0 0 0
0 0 0 0 1 1 0 0
4
3 1 2 6
 */