package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            // n 이 짝수 일때, n/2 * -1
            // n 이 홀수 일떄, (n+1) / 2
            int res = n % 2 == 0 ? (n / 2) * -1 : (n + 1) / 2;
            System.out.println("#" + i + " " + res);
        }
    }
}