package BOJ.DivdeAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solve(a % c, b, c));
    }

    // a^10 = a^5 * a^5
    // a^11 = a^5 * a^5 * a
    private static long solve(int i, int b, int c) {
        if (b == 1) {
            return i;
        }
        long x = solve(i, b / 2, c);
        if (b % 2 == 1) {
            return ((x * x) % c * i) % c;
        } else {
            return (x * x) % c;
        }
    }

}
