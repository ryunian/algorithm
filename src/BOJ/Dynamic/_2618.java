package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2618 {
    static int n, w, cnt = 0;
    static Pair[] first, second;
    static int[][] dp;
    static ArrayList<Integer> list = new ArrayList();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        dp = new int[w+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        first = new Pair[w+1];
        first[0] = new Pair(1,1);
        second = new Pair[w+1];
        second[0] = new Pair(n, n);
        StringTokenizer st;
        for (int i = 1; i <= w; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            first[i] = new Pair(a, b);
            second[i] = new Pair(a, b);
        }
        System.out.println(func(0, 0));
        solve(0,0);

        StringBuilder sb = new StringBuilder();
        for(int x : list){
            sb.append(x+"\n");
        }

        System.out.println(sb.toString());


    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int func(int n1, int n2){
        if (n1 == w || n2 == w) {
            return 0;
        }
        int ref = dp[n1][n2];
        if (ref != -1)
            return ref;

        int next = Math.max(n1, n2) + 1;
        int n1Dis = Math.abs(first[n1].x - first[next].x) + Math.abs(first[n1].y - first[next].y);
        int nextVal = func(next, n2) + n1Dis;

        int n2Dis = Math.abs(second[n2].x - second[next].x) + Math.abs(second[n2].y - second[next].y);
        int nextVal2 = func(n1, next) + n2Dis;

        return dp[n1][n2] = Math.min(nextVal, nextVal2);

    }

    // n1 : 첫번쨰 경찰차가 해결한 사건번호
    // n2 : 두번째 경찰차가 해결한 사건번호
    private static void solve(int n1, int n2) {
        if (n1 == w || n2 == w) {
            return;
        }

        // 다음 사건번호
        int next = Math.max(n1, n2) + 1;
        int n1Dis = Math.abs(first[n1].x - first[next].x) + Math.abs(first[n1].y - first[next].y);
        int n1Val = dp[next][n2] + n1Dis;

        int n2Dis = Math.abs(second[n2].x - second[next].x) + Math.abs(second[n2].y - second[next].y);
        int n2Val = dp[n1][next] + n2Dis;

        if (n1Val > n2Val) {
            list.add(2);
            solve(n1, next);
        } else {
            list.add(1);
            solve(next, n2);
        }
    }
}
















