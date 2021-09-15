package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내려가기
public class _2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] min = new int[n][3];
        int[][] max = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int val = Integer.parseInt(st.nextToken());
                min[i][j] = val;
                max[i][j] = val;
            }
        }

        for (int i = 1; i < n; i++) {
            max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]);
            max[i][1] += Math.max(Math.max(max[i - 1][0], max[i - 1][1]), max[i - 1][2]);
            max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]);

            min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]);
            min[i][1] += Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]);
            min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]);

        }
        int maxVal = Math.max(Math.max(max[n-1][0], max[n-1][1]), max[n-1][2]);
        int minVal = Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]);
        System.out.println(maxVal + " " + minVal);
    }
}
