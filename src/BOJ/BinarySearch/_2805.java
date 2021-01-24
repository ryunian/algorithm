package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805 {
    static long m, res = 0;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        long max = 0;
        arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            long tree = Long.parseLong(st.nextToken());
            arr[i] = tree;
            max = Math.max(max, tree);
        }
        solve(1, max);
        System.out.println(res);
    }

    private static void solve(long left, long right) {
        if (left > right) return;

        long mid = (left + right) / 2;
        long cnt = 0;
        for (long tree : arr) {
            if(tree > mid ){
                cnt += tree - mid;
            }
        }
        if(cnt >= m) res = Math.max(res, mid);

        if(cnt > m){
            solve(mid+1, right);
        }else{
            solve(left, mid-1);
        }
    }
}
