package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 {
    static int n;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x == 1 ? true : false;
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            solve(a, b);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i] ? 1 : 0);
            if(i % 20 == 0){
                sb.append("\n");
            }else {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }

    private static void solve(int a, int b) {
        if (a == 1) {
            for (int i = b; i <= n; i += b) {
                arr[i] = !arr[i];
            }
        } else {
            int left = b - 1;
            int right = b + 1;
            arr[b] = !arr[b];
            while (left > 0 && right <= n && arr[left] == arr[right]) {
                arr[left] = !arr[left];
                arr[right] = !arr[right];
                left--;
                right++;
            }
        }
    }
}
