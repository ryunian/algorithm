package BOJ.DataStructures;

import java.util.*;

public class _10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] x = sc.nextLine().split(" ");
            switch (x[0]){
                case "push" :
                    queue.add(Integer.parseInt(x[1]));
                    break;
                case "pop" :
                    sb.append(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "size" :
                    sb.append(queue.size());
                    break;
                case "empty" :
                    sb.append(queue.isEmpty() ? 1 : 0);
                    break;
                case "front" :
                    sb.append(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back" :
                    LinkedList list = new LinkedList(queue);
                    sb.append(queue.isEmpty() ? -1 : list.get(list.size()-1));
                    break;
            }
            if(!x[0].equals("push")) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
