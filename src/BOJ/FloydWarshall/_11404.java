package BOJ.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11404 {
    static int n, m, INF = 987654321;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j) map[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] x = br.readLine().split(" ");
            int a = Integer.parseInt(x[0]) - 1;
            int b = Integer.parseInt(x[1]) - 1;
            int c = Integer.parseInt(x[2]);

            map[a][b] = Math.min(map[a][b], c);
        }

        floydWarshall();
        print();
    }

    // 플로이드 - 워셜
    private static void floydWarshall() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == INF) {
                    sb.append(0+" ");
                } else {
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
