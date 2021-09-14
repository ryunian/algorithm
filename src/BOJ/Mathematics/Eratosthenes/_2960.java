package BOJ.Mathematics.Eratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n+1];
        int idx = 0;
        loop :
        for (int i = 2; i <= n; i++) {
            if(arr[i]) continue;
            for (int j = i; j <=n; j+= i) {
                if(!arr[j]){
                    arr[j] = true;
                    idx++;

                }
                if(idx == m){
                    System.out.println(j);
                    break loop;
                }
            }
        }
    }
}
