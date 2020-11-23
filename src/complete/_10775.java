package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10775 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // union-find 알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 게이트의 수
        int m = Integer.parseInt(br.readLine()); // 비행기의 수

        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        int[] gate = new int[m];
        for (int i = 0; i < m; i++) {
            gate[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(gate));
//        System.out.println(Arrays.toString(arr)+"  "+Arrays.toString(arr));
//        System.out.println();

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int x = find(gate[i]);
            if(x == 0) break;
            cnt++;
//            System.out.print(Arrays.toString(arr)+"  ");
            union(x, x-1);
//            System.out.println(Arrays.toString(arr) + "  "+ gate[i]);
        }
        System.out.println(cnt);
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        arr[a] = b;
    }
    private static int find(int x){
        if(arr[x] == x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }
}
