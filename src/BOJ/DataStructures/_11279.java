package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                sb.append(queue.isEmpty() ? 0 : queue.poll()).append("\n");
            }else {
                queue.add(x);
            }
        }
        System.out.println(sb);
    }
}
