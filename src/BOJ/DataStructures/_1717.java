package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0){
                b = find(b);
                c = find(c);
//                System.out.println(b +" "+ c);
                if(b < c) union(b,c);
                else union(c,b);

            }else{
                if(find(b) == find(c)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
//            System.out.println(Arrays.toString(arr));
        }


    }
    private static int find(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        arr[y] = x;
    }
}
