package BOJ.Mathematics.Eratosthenes;

import java.util.*;

public class _1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        int max = (int) Math.sqrt(Math.pow(10, 14));

        boolean[] arr = new boolean[max];
        Queue<Long> queue = new LinkedList<>();
        Set<Long> set = new HashSet<>();

        for (int i = 2; i < max; i++) {
            if (arr[i]) continue;
            queue.add((long) i);
            for (int j = i + i; j < max; j += i) {
                arr[j] = true;
            }
        }

        while (!queue.isEmpty() && queue.peek() <= b) {
            long num = queue.poll();
            long cnt = 2;
            long tmp = (long) Math.pow(num, cnt);
            while (tmp <= b){
                if(a <= tmp){
                    set.add(tmp);
                }
                tmp = (long) Math.pow(num, ++cnt);
            }
        }
        System.out.println(set.size());
    }
}
