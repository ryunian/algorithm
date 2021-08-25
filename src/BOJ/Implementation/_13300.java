package BOJ.Implementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

// 방배정
public class _13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() == 1 ? 1 : -1;
            int b = sc.nextInt() * a;
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        int res = 0;
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
            int x = map.get(it.next());
            int a = x / k;
            int b = x % k == 0 ? 0 : 1;
            res += a + b;
        }
        System.out.println(res);

    }
}
