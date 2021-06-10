package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = n + 2 + 1;

        boolean[] sleep = new boolean[max];
        int[] check = new int[max];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sleep[tmp] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (sleep[tmp]) continue;
            for (int j = tmp; j < max; j += tmp) {
                if (!sleep[j]) {
                    check[j] = 1;
                }
            }
        }
        int[] sum = new int[max];
        for (int i = 3; i < max; i++) {
            sum[i] = sum[i - 1] + (check[i] == 1 ? 0 : 1);
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(sum[b] - sum[a - 1]);
        }
    }
}