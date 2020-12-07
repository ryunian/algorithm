package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n+1];
        arr[0] = 1;
        solve(1, n,arr);
        System.out.println(arr[n]);
    }

    private static void solve(int i, int n, long[] arr) {
        if(i == 1) arr[i] = 1;
        else{
            arr[i] = (arr[i-2] + arr[i-1]) % 10007;
        }
        if(n != i){
            solve(i+1, n, arr);
        }
    }
}
