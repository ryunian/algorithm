package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2407 {
    static BigInteger[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new BigInteger[n+1];
        solve(n);

        BigInteger result = arr[n].divide(arr[n-m].multiply(arr[m]));
        System.out.println(result);

    }

    private static void solve(int n) {
        if(n == 0){
            arr[0] = BigInteger.valueOf(1);
            return;
        }
        solve(n-1);
        arr[n] = arr[n-1].multiply(BigInteger.valueOf(n));

    }
}
