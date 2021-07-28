package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _21773 {
    static int n;
    static PriorityQueue<Node> pq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 우선순위 내림차순 - ID 오름차순
        pq = new PriorityQueue<>(Comparator.comparing(Node::getPriority, Comparator.reverseOrder()).thenComparing(Node::getid));
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        solve(1);
        System.out.print(sb);
    }

    private static void solve(int cnt) {
        if (cnt > n) return;

        Node cur = pq.poll();
        sb.append(cur.id + "\n");

        if (--cur.time > 0) {
            // 나머지 프로세스들의 우선순위를 올린다는 의미는 현재 프로세스의 우선순위를 낮춘다는 의미
            cur.priority--;
            pq.add(cur); // 처리할 시간이 남았으므로 다시 큐에 넣는다.
        }

        solve(cnt + 1);
    }

    static class Node {
        int id;
        int time;
        int priority;

        public Node(int id, int time, int priority) {
            this.id = id;
            this.time = time;
            this.priority = priority;
        }

        public int getid() {
            return id;
        }

        public int getPriority() {
            return priority;
        }
    }
}
