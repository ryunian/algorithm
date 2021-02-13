package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000 {
    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Pair(a, b));
        }

        list.sort(Comparator.comparing(o -> o.x));
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));

        for (int i = 0; i < list.size(); i++) {
            if (queue.isEmpty()) {
                queue.add(list.get(i));
            } else {
                if (queue.peek().y <= list.get(i).x) {
                    queue.poll();
                    queue.add(list.get(i));
                } else {
                    queue.add(list.get(i));
                }
            }
        }
        System.out.println(queue.size());
    }
}
