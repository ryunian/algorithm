package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 게리맨더링
public class _17471 {
    static int n, min = Integer.MAX_VALUE;
    static int[] arr;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visit = new boolean[n + 1];
        list = new List[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while (x-- > 0) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= n; i++) {
            dfs(1, 0, i);
        }
        System.out.println(min > 1000 ? -1 : min);
    }

    private static void dfs(int start, int cnt, int r) {
        if (r == 0) {
            check(cnt);
            return;
        }

        for (int next = start; next <= n; next++) {
            visit[next] = true;
            dfs(next + 1, cnt + 1, r - 1);
            visit[next] = false;
        }
    }

    private static void check(int cnt) {
        if (cnt == 0 || cnt == n) return;
        if (!bfs(true, cnt)) return;
        if (!bfs(false, n - cnt)) return;

        int x = 0;
        int y = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i]) {
                x += arr[i];
            } else {
                y += arr[i];
            }
        }
        min = Math.min(min, Math.abs(x - y));
    }

    private static boolean bfs(boolean flag, int total) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] chk = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visit[i] == flag) {
                chk[i] = true;
                queue.add(i);
                break;
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;

            for (int next : list[cur]) {
                if (visit[next] != flag) continue;
                if (chk[next]) continue;
                chk[next] = true;
                queue.add(next);
            }
        }
        if (cnt == total) return true;
        return false;
    }
}
