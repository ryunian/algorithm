package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 우선순위 큐를 이용해서 중간값 찾기
public class _1655 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            // 새로들어온 수를 min, max 힙에 넣는다.
            min.add(x);
            max.add(x);

            // 각각 poll을 해서
            int a = min.poll();
            int b = max.poll();
            // 서로 다른 쪽에 넣어준다.
            min.add(b);
            max.add(a);
            int res = Math.min(min.peek(), max.peek());
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
    }
}
