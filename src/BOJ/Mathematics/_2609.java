package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = maxSolve(n,m); // 최대 공약수
//        int min = minSolve(n,m); // 최소 공배수
        int min = n*m / max;
        System.out.println(max);
        System.out.println(min);

    }

    private static int maxSolve(int n , int m) {
        while(m > 0){
            int tmp = m;
            m = n % m;
            n = tmp;
        }
        return n;
    }

    // 최소 공배수
    private static int minSolve(int n, int m) {
        for (int i = 1; i <= m; i++) {
            if(n*i % m == 0) {
                return n*i;
            }
        }
        return 0;
    }
}
