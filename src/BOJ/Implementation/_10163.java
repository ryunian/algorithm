package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class _10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[1002][1002];
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for (int j = b; j < b + d; j++) {
                for (int k = a; k < a + c; k++) {
                    map[j][k] = i;
                }
            }
        }

        for (int i = 0; i < 1002; i++) {
            for (int j = 0; j < 1002; j++) {
                arr[map[i][j]]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }
}
