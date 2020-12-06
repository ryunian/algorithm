package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        System.out.println(factorial(n));

        int result = factorial(n) / (factorial(n-m) * factorial(m));
        System.out.println(result);
    }

    private static int factorial(int x) {
        if(x == 0){
            return 1;
        }

        return x * factorial(x-1);
    }
}
