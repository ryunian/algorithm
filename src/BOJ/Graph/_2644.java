package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2644 {
    static int res = -1;
    static boolean[] visit;
    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        info = new int[n+1][n+1];
        visit = new boolean[n+1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[a][b] = info[b][a] = 1;
        }

        solve(x, y,n, 0);
        System.out.println(res);
    }

    private static void solve(int x, int y,int size,  int num) {
        if (x == y) {
            res = num;
            return;
        }
        visit[x] = true;
        for (int i = 1; i <= size; i++) {
            if(info[x][i] == 1 && !visit[i]){
                solve(i, y, size, num+1);
            }
        }
    }
}
