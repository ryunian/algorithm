package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819 {
    static int max = -801, x;
    static int[] orgArr, tmpArr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        orgArr = new int[x];
        tmpArr = new int[x];
        visit = new boolean[x];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++) {
            orgArr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);
        System.out.println(max);
    }

    private static void solve(int n) {
        if (n == x) {
            int tmp = 0;
            for (int i = 0; i < x-1; i++) {
                tmp += Math.abs(tmpArr[i] - tmpArr[i+1]);
            }
            max = Math.max(max, tmp);
            return;
        }
        for (int i = 0; i < x; i++) {
            if(!visit[i]){
                visit[i] = true;
                tmpArr[n] = orgArr[i];
                solve(n+1);
                visit[i] = false;
            }
        }
    }
}
