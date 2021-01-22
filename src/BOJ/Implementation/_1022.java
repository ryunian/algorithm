package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1022 {
    static int a, b, c, d, MAX = Integer.MIN_VALUE;
    // 동 북 서 남
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[c - a + 1][d - b + 1];

        draw(0,0);

        int len = String.valueOf(MAX).length();
        for (int[] arr : map) {
            for (int i : arr) {
                String str = String.valueOf(i);
                while(str.length() < len){
                    str = " "+str;
                }
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    private static void draw(int x, int y) {
        int cnt = 0, dir = 0;
        int num = 1, jump = 1;

        while (!isFinish()) {
            if (x >= a && y >= b && x <= c && y <= d) {
                map[x - a][y - b] = num;
                MAX = Math.max(MAX, num);
            }
            x += dx[dir % 4];
            y += dy[dir % 4];
            num++;
            cnt++;
            if (cnt == jump) {
                // 초기화
                cnt = 0;
                // jump만큼 이동했을 경우 방향을 전환한다.
                dir++;
                // 방향을 2번 전환했을 경우 jump의 수를 추가한다
                if (dir % 2 == 0) jump++;
            }
        }

    }
    private static boolean isFinish(){
        return map[0][0] != 0 && map[c-a][0] != 0 && map[0][d-b] != 0 && map[c-a][d-b] != 0;
    }
}
