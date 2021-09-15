package BOJ.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내려가기 ver.2
// 1차원배열만 사용하기
public class _2096_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] min = new int[3];
        int[] max = new int[3];
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int a1 = a + Math.max(max[0], max[1]);
            int b1 = b + Math.max(Math.max(max[0], max[1]), max[2]);
            int c1 = c + Math.max(max[1], max[2]);

            int a2 = a + Math.min(min[0], min[1]);
            int b2 = b + Math.min(Math.min(min[0], min[1]), min[2]);
            int c2 = c + Math.min(min[1], min[2]);

            max[0] = a1; max[1] = b1; max[2] = c1;
            min[0] = a2; min[1] = b2; min[2] = c2;
        }

        int maxVal = Math.max(Math.max(max[0], max[1]), max[2]);
        int minVal = Math.min(Math.min(min[0], min[1]), min[2]);
        System.out.println(maxVal + " " + minVal);
    }
}
