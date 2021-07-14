package BOJ.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class _17252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();

        long n = sc.nextLong();
        long x = 1;
        while (x <= n) {
            list.add(x);
            x *= 3;
        }

        int idx = list.size() - 1;
        boolean isOk = n == 0 ? false : true;
        int cnt = 0;
        while (0 < n) {
            if (n >= list.get(idx)) {
                cnt++;
                n -= list.get(idx);
            } else {
                idx--;
                cnt = 0;
            }

            if (cnt > 1){
                isOk = false;
                break;
            }
        }

        if (isOk) System.out.println("YES");
        else System.out.println("NO");
    }
}
