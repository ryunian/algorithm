package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int x = 15, y = 28, z = 19;

        int n = 1;
        while (true) {
            if ((n - a) % x == 0 && (n - b) % y == 0 && (n - c) % z == 0) {
                break;
            }
            n++;
        }
        System.out.println(n);

    }
}
