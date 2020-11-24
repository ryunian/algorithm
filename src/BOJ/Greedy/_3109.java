package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3109 {
    static boolean[][] arr;
    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                if (line.charAt(j - 1) != 'x') {
                    arr[i][j] = true;
                }
            }
        }

//        for (boolean[] a : arr) {
//            for (boolean b : a) {
//                int x = b ? 0 : 1;
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= n; i++) {
            cnt += solution(i, 1, 0);
        }
//        System.out.println();
        System.out.println(cnt);
    }

    private static int solution(int x, int y, int z) {
        if (y == m-1) {
            return 1;
        }
        int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
        for (int i = 0; i < 3; i++) {

            int x2 = x + dir[i][0];
            int y2 = y + dir[i][1];
//            System.out.println(x + "  "+y + "     //"+arr[x][y]+arr[x2][y2]+ "    //"+x2 + "  "+ y2);
            if (arr[x2][y2]) {
                arr[x2][y2] = false;
//                System.out.println(x +"   "+ y);
                int result = solution(x2, y2, ++z);
                if(result != 0) return result;
            }
        }
        return 0;
    }
}
