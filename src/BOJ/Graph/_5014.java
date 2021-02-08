package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5014 {
    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        solve();
    }

    private static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[f +1];
        Arrays.fill(visit, -1);
        queue.add(s);
        visit[s] = 0;
        int res = Integer.MAX_VALUE;
        boolean isFind = false;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == g) {
                res = visit[cur];
                isFind = true;
                break;
            }

            for (int i = 0; i < 2; i++) {
                int next = cur;
                if (i == 0) {
                    next += u;
                } else {
                    next -= d;
                }
                if (next < 1 || next > f) continue;
                visit[next] = Math.min(visit[next], visit[cur]+1);

                if(visit[next] == -1){
                    visit[next] = visit[cur]+1;
                    queue.add(next);
                }
            }
        }
        if(isFind){
            System.out.println(res);
        }else{
            System.out.println("use the stairs");
        }
    }
}
