package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합
public class _3289 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = i;
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a == 0) {
                    union(b, c);
                } else {
                    int res = find(b) == find(c) ? 1 : 0;
                    sb.append(res);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) arr[a] = b;
    }

    private static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }
}
