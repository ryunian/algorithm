package BOJ.Dynamic;

import java.util.ArrayList;
import java.util.Scanner;

// top-down 으로 설계시 stack overflow가 발생함으로 주의
public class _17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int INF = 987654321;
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        ArrayList<Integer> list = new ArrayList<>();
        int x = 1;
        while ((int) Math.pow(x, 2) <= n) {
            list.add((int) Math.pow(x, 2));
            x++;
        }

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = INF;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > i) break;
                tmp = Math.min(tmp, dp[i - list.get(j)]);
            }
            dp[i] = tmp + 1;
        }

        System.out.println(dp[n]);
    }
}
