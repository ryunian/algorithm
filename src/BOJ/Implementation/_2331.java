package BOJ.Implementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class _2331 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        while (true) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > 2) {
                break;
            }
            n = solve(n, p);
        }
        int res = 0;
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
            if (map.get(it.next()) == 1) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static int solve(int n, int p) {
        int sum = 0;
        while (n > 0) {
            sum += (int) Math.pow(n % 10, p);
            n /= 10;
        }
        return sum;
    }
}
