package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int sum = 0;
            int x = n / 2;
            int y = 0;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = x; j <= x + y; j++) {
                    sum += arr[i][j];
                }
                if (i == n / 2) flag = !flag;
                if (flag) {
                    x--;
                    y += 2;
                } else {
                    x++;
                    y -= 2;
                }
            }
            String out = String.format("#%d %d\n", t, sum);
            sb.append(out);
        }
        System.out.print(sb.toString());
    }
}
