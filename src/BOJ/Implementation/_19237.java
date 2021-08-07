package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _19237 {
    static int n, m, k;
    static int[][][] smell;
    static List<Shark> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Shark {
        int x;
        int y;
        int num;
        int dir;
        int[][] priority = new int[4][4];

        public Shark(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 격자크기
        m = Integer.parseInt(st.nextToken()); // 상어 수
        k = Integer.parseInt(st.nextToken()); // 냄새가 남는 시간
        smell = new int[n + 1][n + 1][2]; // 냄새를 남긴 시간과 상어를 저장하는 배열
        list = new ArrayList<>(); // 상어 리스트

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x != 0) {
                    list.add(new Shark(i, j, x));
                }
                smell[i][j][0] = -1000;
            }
        }

        // 작은숫자의 상어가 먼저 움직여야함
        list.sort(Comparator.comparing(o -> o.num));

        // 상어 이동방향
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.get(i).dir = Integer.parseInt(st.nextToken()) - 1;
        }

        // 우선순위
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < 4; l++) {
                    list.get(i).priority[j][l] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        // run
        solve();
    }

    private static void solve() {
        int time = 0;
        while (time <= 1000) {
            // 냄새를 뿌리면서 겹치는 상어를 없앤다
            Spray(time);
            if (list.size() == 1) break;

            // 상어가 움직인다.
            move(time);
            time++;
        }
        System.out.println(time > 1000 ? -1 : time);
    }


    private static void Spray(int time) {
        List<Shark> tmp = new ArrayList<>();
        for (Shark shark : list) {
            int x = shark.x;
            int y = shark.y;
            int num = shark.num;

            // 같은시간에 작은번호의 상어가 먼저 냄새를 남겻을 경우
            if (smell[x][y][0] == time) continue;

            // 냄새와 번호를 저장
            smell[x][y][0] = time;
            smell[x][y][1] = num;
            tmp.add(shark);
        }
        list = tmp;
    }


    private static void move(int time) {
        for (int idx = 0; idx < list.size(); idx++) {
            Shark shark = list.get(idx);
            int x = shark.x;
            int y = shark.y;
            int num = shark.num;
            int dir = shark.dir;
            int[][] priority = shark.priority;

            int tmpX = -1;
            int tmpY = -1;
            int tmpDir = -1;
            boolean isOk = false;
            for (int j = 0; j < 4; j++) {
                int nDir = priority[dir][j];
                int nx = x + dx[nDir];
                int ny = y + dy[nDir];

                if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;

                // 자신의 냄새를 찾은 칸 값 저장
                if (tmpX == -1 && smell[nx][ny][1] == num) {
                    tmpX = nx;
                    tmpY = ny;
                    tmpDir = nDir;
                }
                // 냄새가 남아 있을 경우 넘어간다
                if (smell[nx][ny][0] + k > time) continue;
                isOk = true;
                shark.x = nx;
                shark.y = ny;
                shark.dir = nDir;
                break;
            }
            if (!isOk && tmpX != -1) {
                shark.x = tmpX;
                shark.y = tmpY;
                shark.dir = tmpDir;
            }
        }
    }
}
