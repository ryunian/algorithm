package complete;

import java.io.*;
import java.util.StringTokenizer;

public class _1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            String x = br.readLine();
            for (int j = 0; j < M; j++) {
                arr1[i][j] = x.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String x = br.readLine();
            for (int j = 0; j < M; j++) {
                arr2[i][j] = x.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    reverse(arr1, i, j);
                    cnt++;
                }
            }
        }
        for(int i = 0; i<N ; i++){
            for(int j = 0; j< M ; j++){
                if (arr1[i][j] != arr2[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void reverse(int[][] arr, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
    }
}
