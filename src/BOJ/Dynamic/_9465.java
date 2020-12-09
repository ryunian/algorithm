package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            int[][] arr = new int[3][m+1];

            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                int x = Integer.parseInt(a[j-1]);
                int y = Integer.parseInt(b[j-1]);
                arr[0][j] = x + Math.max(arr[1][j-1], arr[2][j-1]);
                arr[1][j] = y + Math.max(arr[0][j-1], arr[2][j-1]);
                arr[2][j] = Math.max(arr[0][j-1], arr[1][j-1]);
            }

            System.out.println(Math.max(Math.max(arr[0][m],arr[1][m]), arr[2][m]));
        }
    }
}
