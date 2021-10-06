package SWEA.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 점심 식사시간
public class _2383 {
    static int n, k, res;
    static ArrayList<Pair> list, exit;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            exit = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    if (val == 1) {
                        list.add(new Pair(i, j, 1));
                    } else if (val > 1) {
                        exit.add(new Pair(i, j, val));
                    }
                }
            }
            k = list.size();
            visit = new boolean[k];
            res = Integer.MAX_VALUE;
            solve(0, 0);
            System.out.printf("#%d %d\n", tc, res);
        }
    }

    private static void solve(int idx, int cnt) {
        if (cnt == k) {
            PriorityQueue<Integer> a = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            PriorityQueue<Integer> b = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            for (int i = 0; i < k; i++) {
                if (visit[i]) {
                    a.add(calcu(0, i));
                } else {
                    b.add(calcu(1, i));
                }
            }
            int x = time(a, exit.get(0).val);
            int y = time(b, exit.get(1).val);
            res = Math.min(res, Math.max(x, y));

            return;
        }

        visit[idx] = true;
        solve(idx + 1, cnt + 1);
        visit[idx] = false;
        solve(idx + 1, cnt + 1);

    }

    private static int time(PriorityQueue<Integer> pq, int plus) {
        Queue<Integer> queue = new LinkedList<>();
        int time = -1;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            while (!queue.isEmpty() && queue.peek() <= time) queue.poll();
            while (queue.size() < 3 && !pq.isEmpty() && pq.peek() <= time) {
                pq.poll();
                queue.add(time + plus);
            }
        }
        return time;
    }

    static int calcu(int a, int b) {
        int x = Math.abs(exit.get(a).x - list.get(b).x);
        int y = Math.abs(exit.get(a).y - list.get(b).y);
        return x + y + 1;
    }

    static class Pair {
        int x, y, val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
