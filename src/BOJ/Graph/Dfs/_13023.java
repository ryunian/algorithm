package BOJ.Graph.Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _13023 {
    private static int n;
    private static boolean isPossible = false;
    private static ArrayList<Integer>[] list;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            solve(i, 1);
        }
        System.out.println(isPossible ? 1 : 0);
    }

    private static void solve(int idx, int cnt) {
        if (isPossible) return;
        if (cnt == 5) {
            isPossible = true;
            return;
        }

        for (int next : list[idx]) {
            if (!visit[next]) {
                visit[idx] = true;
                solve(next, cnt + 1);
                visit[idx] = false;
            }
        }
    }
}
