package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> sosu = new ArrayList<>();
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (arr[i]) continue;
            sosu.add(i);
            for (int j = i + i; j <= n; j += i) {
                arr[j] = true;
            }
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            int x = sosu.get(idx);
            if (n % x == 0) {
                sb.append(x + "\n");
                n /= x;
            } else {
                idx++;
            }
        }
        System.out.print(sb.toString());
    }
}
