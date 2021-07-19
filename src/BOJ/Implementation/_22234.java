package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _22234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        Queue<Node> queue = new LinkedList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new Node(a, b));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w; i++) {
            // 현재 시간에 온 손님은 queue 에 삽입
            if (!pq.isEmpty() && pq.peek().w == i) {
                queue.add(pq.poll());
            }

            // 업무를 처리후 손님의 업무가 마무리되었을 경우 밖으로 보낸다.
            if (queue.peek().time == 0) {
                queue.poll();
                cnt = 0;
            }
            // 주어진 시간만큼 처리했을 경우 뒤로 보낸다.
            else if (cnt == t) {
                cnt = 0;
                queue.add(queue.poll());
            }
            // 창구에서 업무를 처리한다.
            queue.peek().time--;
            sb.append(queue.peek().id+"\n");
            cnt++;
        }
        System.out.print(sb.toString());
    }

    private static class Node {
        int id;
        int time;
        int w;

        public Node(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public Node(int id, int time, int w) {
            this.id = id;
            this.time = time;
            this.w = w;
        }
    }
}
