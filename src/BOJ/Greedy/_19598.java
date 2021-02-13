package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _19598 {
    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> list = new ArrayList<>();
        ArrayList<Pair> list_2 = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(a, b));
            list_2.add(new Pair(a, 1));
            list_2.add(new Pair(b, -1));
        }
//        solve_1(list);
        solve_2(list_2);
    }

    // 우선순위 큐를 이용한 방법
    // 다음의 x 가 queue.peek 의 y 값보다 크거나 같을 경우 갱신시키고
    // 적을 경우 queue에 삽입한다.
    private static void solve_1(ArrayList<Pair> list) {
        list.sort(Comparator.comparing(o -> o.x));
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));
        queue.add(list.get(0));
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (queue.peek().y <= list.get(i).x) {
                Pair pair = queue.poll();
                queue.add(new Pair(pair.x, list.get(i).y));
            } else {
                queue.add(list.get(i));
            }
            res = Math.max(queue.size(), res);
        }
        System.out.println(res);
    }

    // 해당값이 들어갈떄 +1 시키고 해당값이 종료될떄 -1을 시키면서 cnt의 최대값을 찾는방법
    // 단, x값이 같을 경우 y값이 -1보다 +1이 앞에 나와야한다.
    private static void solve_2(ArrayList<Pair> list) {
        list.sort(Comparator.comparing(Pair::getX).thenComparing(Pair::getY));
        int cnt = 0;
        int res = 0;
        for (Pair pair : list) {
            cnt += pair.y;
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }
}
