package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16287 {
    static int weight;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 무게
        weight = Integer.parseInt(st.nextToken());
        // 개수
        int n = Integer.parseInt(st.nextToken());

        // 물품
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] sum = new boolean[800001];
        // a+b+c+d = w
        // a+b = w-c-d
        loop :
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int ab = arr[i] + arr[j];
                if(ab >= weight || weight-ab > 800000) continue;
                if(sum[weight-ab]){
                    result = true;
                    break loop;
                }
            }
            for (int j = 0; j < i; j++) {
                sum[arr[i]+arr[j]] = true;
            }
        }
        System.out.println(result ? "YES":"NO");
    }

}
