package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14891 {
    static int[][] gear;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][9];

        for (int i = 0; i < 4; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str[j] - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            check = new boolean[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int way = Integer.parseInt(st.nextToken());
            move(n, way);
        }
        int res = 0;
        res += gear[0][0] == 1 ? 1 : 0;
        res += gear[1][0] == 1 ? 2 : 0;
        res += gear[2][0] == 1 ? 4 : 0;
        res += gear[3][0] == 1 ? 8 : 0;

        System.out.println(res);

    }
    private static void move(int n, int way) {
        if(check[n]) return;
        check[n] = true;

        if (n != 0 && gear[n][6] != gear[n - 1][2]) {
            move(n - 1, way * -1);
        }
        if (n != 3 && gear[n][2] != gear[n + 1][6]) {
            move(n + 1, way * -1);
        }

        if (way == 1) {
            right(n);
        } else if (way == -1) {
            left(n);
        }
    }

    private static void left(int n) {
        gear[n][8] = gear[n][0];
        for (int i = 1; i <= 8; i++) {
            gear[n][i - 1] = gear[n][i];
        }
    }

    private static void right(int n) {
        for (int i = 7; i >= 0; i--) {
            gear[n][i + 1] = gear[n][i];
        }
        gear[n][0] = gear[n][8];
    }

}
