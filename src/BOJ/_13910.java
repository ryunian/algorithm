package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _13910 {
    private static int[] dp;
    private static int n, m;
    private static int INF = 987654321;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                list.add(list.get(i) + list.get(j));
            }
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int res = solve(n);
        System.out.println(res >= INF ? -1 : res);
    }

    private static int solve(int food) {
        if (food == 0) return 0;

        int ret = dp[food];
        if (ret != -1) return ret;
        ret = INF;

        for (int i = 0; i < list.size(); i++) {
            if (food >= list.get(i)) {
                ret = Math.min(ret, solve(food - list.get(i)) + 1);
            }
        }
        return dp[food] = ret;
    }
}
