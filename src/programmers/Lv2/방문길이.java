package programmers.Lv2;

import java.util.*;

public class 방문길이 {
    Map<Character, Integer> map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(String dirs) {
        init();
        int x = 5;
        int y = 5;
        boolean[][][] visit = new boolean[11][11][4];
        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int dir = map.get(dirs.charAt(i));
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            if (!visit[nx][ny][(dir + 2) % 4]) {
                answer++;
            }
            visit[nx][ny][(dir + 2) % 4] = true;
            visit[x][y][dir] = true;
            x = nx;
            y = ny;
        }

        return answer;
    }

    public void init() {
        map = new HashMap<>();
        map.put('U', 0);
        map.put('R', 1);
        map.put('D', 2);
        map.put('L', 3);
    }
}
