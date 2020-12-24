package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2533 {
    static int n;
    static ArrayList<Integer>[] list;
    static int[][] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // root 가 얼리 어답터일떄
        int x = dfs(0, 1, 1);
        // 아닐떄
        int y = dfs(0, 1, 0);
        System.out.println(Math.min(x,y));
    }
/*
    1. 자신이 얼리어답터일때 , 자식은 얼리어답터일수도있고 아닐수도있다.
    2. 자신이 얼리어답터가 아닐떄, 자식은 무조건 얼리어답터이다.
 */

    private static int dfs(int prev, int cur, int earlyAdaptor) {
        if (dp[cur][earlyAdaptor] != 0) return dp[cur][earlyAdaptor];

        int res = 0;
        if (earlyAdaptor == 1) {
            res = 1;
            for (int next : list[cur]){
                if (next == prev) continue;
                res += Math.min(dfs(cur, next, 1), dfs(cur, next, 0));
            }
        } else {
            for (int next : list[cur]){
                if (next == prev) continue;
                res += dfs(cur, next, 1);
            }
        }

        return dp[cur][earlyAdaptor] = res;
    }
}
