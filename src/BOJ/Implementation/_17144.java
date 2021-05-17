package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17144 {
    static int row, col;
    static int[][] map;
    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 공기청정기의 위치를 담는 리스트
        // index 가 짝수일경우 위쪽, 홀수일경우 아랫쪽
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == -1) {
                    list.add(new Pair(i, j));
                    list.add(new Pair(i + 1, j));
                    // 체크하기 위해 -2로 변경
                    map[i][j] = map[i + 1][j] = -2;
                }
            }
        }

        while (time-- > 0) {
            // 미세먼지가 확산된다.
            map = spread(map);
            // 공기청정기가 작동한다.
            purifier(list);
        }

        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != -2) result += map[i][j];
            }
        }
        System.out.println(result);
    }

    public static int[][] spread(int[][] map) {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = map[i][j];
                if (val == 0) continue;
                int x = val / 5;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= row || ny >= col || map[nx][ny] == -2) continue;
                    val -= x;
                    temp[nx][ny] += x;
                }
                temp[i][j] += val;
            }
        }
        return temp;
    }

    private static void purifier(ArrayList<Pair> list) {
        for (int i = 0; i < list.size(); i += 2) {
            move(list.get(i), 1);
            move(list.get(i + 1), -1);
        }
    }

    private static void move(Pair pair, int flag) {
        int rowMin, colMin, rowMax, colMax, way;
        int x = pair.x;
        int y = pair.y;
        int cnt = 0;
        if (flag == 1) {
            way = 0;
            rowMin = 0; rowMax = x + 1;
            colMin = y; colMax = col;
        } else {
            way = 2;
            rowMin = x; rowMax = row;
            colMin = y; colMax = col;
        }

        while (cnt < 4) {
            int nx = x + dx[way];
            int ny = y + dy[way];
            // 모서리에 닿을 경우 방향을 바꾼다.
            if (nx < rowMin || ny < colMin || nx >= rowMax || ny >= colMax) {
                cnt++;
                way += flag;
                way = way == 4 ? 0 : way;
                way = way == -1 ? 3 : way;
            } else {
                // 1. 자신이 공기청정기일경우 -2
                // 2. 이전이 공기청정기일경우 0
                // 3. 둘다 아닐경우 이전값
                if (map[x][y] != -2 && map[nx][ny] != -2) {
                    map[x][y] = map[nx][ny];
                } else if (map[nx][ny] == -2) {
                    map[x][y] = 0;
                }
                x = nx;
                y = ny;
            }
        }
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
