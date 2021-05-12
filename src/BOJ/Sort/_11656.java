package BOJ.Sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.substring(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.poll()+"\n");
        }
        System.out.print(sb.toString());
    }
}
