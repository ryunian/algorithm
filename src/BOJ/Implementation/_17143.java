package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17143 {
    private static class Shark {
        int speed;
        int dis;
        int size;

        public Shark(int speed, int dis, int size) {
            this.speed = speed;
            this.dis = dis;
            this.size = size;
        }
    }

    static int n, m, k, res = 0;
    static Shark[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Shark[n + 1][m + 2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[x][y] = new Shark(s, d, z);
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if(map[i][j] == null){
//                    System.out.print("0 ");
//                }else{
//                    System.out.print(map[i][j].size+" ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();

        solve(0);
    }

    private static void solve(int y) {

        // 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
        y++;
        // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
        // 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
        for (int x = 0; x <= n; x++) {
            if (map[x][y] != null) {
                res += map[x][y].size;
                map[x][y] = null;
                break;
            }
        }
        // 3. 상어가 이동한다.
        move();

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if(map[i][j] == null){
//                    System.out.print("0 ");
//                }else{
//                    System.out.print(map[i][j].size+" ");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();

        // 4. 도착했는지 체크
        if (y == m + 1) {
            System.out.println(res);
        } else {
            solve(y);
        }
    }

    static int[] dx = {0,-1, 1, 0, 0};
    static int[] dy = {0,0, 0, 1, -1};

    // 위 아래 오른쪽 왼쪽
    private static void move() {
        Shark[][] tmp = new Shark[n + 1][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != null) {
                    int speed = map[i][j].speed;
                    int dis = map[i][j].dis;
                    int size = map[i][j].size;

                    int nx = i;
                    int ny = j;
                    int temp = speed;
                    while (temp != 0) {
                        int tmpX = nx + dx[dis];
                        int tmpY = ny + dy[dis];
                        if (tmpX < 1 || tmpY < 1 || tmpX > n || tmpY > m) {
                            if (dis == 1) {
                                dis = 2;
                            } else if (dis == 2) {
                                dis = 1;
                            } else if (dis == 3) {
                                dis = 4;
                            } else {
                                dis = 3;
                            }
                            nx = nx + dx[dis];
                            ny = ny + dy[dis];
                        } else {
                            nx = tmpX;
                            ny = tmpY;
                        }
                        temp--;
                    }
                    if(tmp[nx][ny] == null){
                        tmp[nx][ny] = new Shark(speed,dis, size);
                    }else if(tmp[nx][ny] != null && tmp[nx][ny].size < size){
                        tmp[nx][ny] = new Shark(speed,dis, size);
                    }
                }
            }
        }
        map = tmp;

    }
}
