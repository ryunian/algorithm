package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182 {
    static int n, m, result = 0;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            visit[i] = true;
            solve(i);
            visit[i] = false;
        }
        System.out.println(result);
    }

    private static void solve(int idx) {
        if(idx == n ) return;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(visit[i]){
                sum += arr[i];
            }
        }
        if(sum == m){
            result++;
        }
        for (int i = idx+1; i < n; i++) {
            if(!visit[i]){
                visit[i] = true;
                solve(i);
                visit[i] = false;
            }
        }
    }
}
