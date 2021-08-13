package BOJ.DataStructures.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

// 절대값 힙
public class _11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) < Math.abs(o2)) {
                return -1;
            } else if (Math.abs(o1) > Math.abs(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });

        while (n-- > 0){
            int x = sc.nextInt();
            if(x != 0){
                pq.add(x);
            }else {
                if(pq.isEmpty()){
                    sb.append("0\n");
                }else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
