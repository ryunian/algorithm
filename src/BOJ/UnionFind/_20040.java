package BOJ.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20040 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  i;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){
                res = i +1;
                break;
            }else{
                union(a,b);
            }
        }
        System.out.println(res);
    }

    private static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        arr[a] = b;
    }
}
