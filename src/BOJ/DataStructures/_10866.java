package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList();
        for (int i = 0; i < n; i++) {
            String[] x = br.readLine().split(" ");
            switch (x[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(x[1]));
                    break;
                case "push_back" : // == addlast
                    deque.add(Integer.parseInt(x[1]));
                    break;
                case "pop_front" : // == pollfirst
                    sb.append(deque.isEmpty() ? -1 : deque.poll());
                    break;
                case "pop_back" :
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                case "size" :
                    sb.append(deque.size());
                    break;
                case "empty" :
                    sb.append(deque.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                case "back" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
            if(x.length < 2) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
