package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 최대공약수
            int c = solve(a,b);

            // 최소공배수
            int res = a * b / c;
            System.out.println(res);
        }
    }
    // 유클리드호제법
    private static int solve(int a, int b) {
        return b == 0 ? a : solve(b, a%b);
    }
}
