package BOJ.TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

public class _1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> sosu = new ArrayList<>();
        boolean[] chk = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (chk[i]) continue;
            sosu.add(i);
            for (int j = i; j <= n; j += i) {
                chk[j] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < sosu.size(); i++) {
            int tmp = sosu.get(i);
            for (int j = i + 1; j < sosu.size(); j++) {
                if (tmp + sosu.get(j) > n) {
                    break;
                } else {
                    tmp += sosu.get(j);
                }
            }
            if (tmp == n) {
                res++;
            }
        }
        System.out.println(res);
    }
}