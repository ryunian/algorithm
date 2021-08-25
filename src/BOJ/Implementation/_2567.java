package BOJ.Implementation;

import java.util.Scanner;

// 색종이 2
public class _2567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] map = new boolean[101][101];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10 ; k++) {
                    map[j][k] = true;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int res = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if(!map[i][j]) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx > 100 || ny > 100 || !map[nx][ny]) res++;
                }
            }
        }
        System.out.println(res);
    }

}
