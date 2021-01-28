package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6588 {
    static boolean[] num;

    public static void main(String[] args) throws IOException {
        num = new boolean[1000000];
        for (int i = 2; i < num.length; i++) {
            if (num[i]) continue;
            for (int j = i + i; j < num.length; j += i) {
                num[j] = true;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            solve(2, n);

        }
    }

    private static void solve(int start, int n) {
        int end = n;
        boolean ok = false;
        while (start <= end) {
            if (num[end]) {
                end--;
            } else if (num[start]) {
                start++;
            } else if (!num[start] == !num[end]) {
                int sum = start + end;
                if (sum == n) {
                    ok = true;
                    break;
                } else if (sum > n) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        String result = n + " = " + start + " + " + end;
        System.out.println(ok ? result : "Goldbach's conjecture is wrong.");
    }
}
