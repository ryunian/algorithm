package programmers.Lv3;

import java.util.ArrayList;
import java.util.Arrays;

public class 기둥과보설치 {
    public static void main(String[] args) {
        기둥과보설치 test = new 기둥과보설치();
        test.solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
        test.solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
    }

    public int[][] solution(int n, int[][] build_frame) {
        boolean[][][] map = new boolean[n + 1][n + 1][2];

        for (int[] arr : build_frame) {
            int width = arr[0];
            int height = arr[1];
            int type = arr[2];
            int flag = arr[3];

            // 기둥 설치
            if (type == 0 && flag == 1) {
                if (isBuildPillar(map, height, width)) {
                    map[height][width][0] = true;
                }
            }
            // 기둥 삭제
            else if (type == 0 && flag == 0) {
                map[height][width][0] = false;
                if (!check(map)) {
                    map[height][width][0] = true;
                }
            }
            // 보 설치
            else if (type == 1 && flag == 1) {
                if (isBuildTent(map, height, width)) {
                    map[height][width][1] = true;
                }
            } else if (type == 1 && flag == 0) {
                map[height][width][1] = false;
                if (!check(map)) {
                    map[height][width][1] = true;
                }
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (map[j][i][0]) {
                    list.add(new int[]{i, j, 0});
                }
                if (map[j][i][1]) {
                    list.add(new int[]{i, j, 1});
                }
            }
        }
        int[][] answer = list.toArray(new int[][]{});
        System.out.println(Arrays.deepToString(answer));
        return answer;
    }

    private boolean isBuildPillar(boolean[][][] map, int height, int width) {
        // 기둥은 바닥 위에 있거나
        if (height == 0) {
            return true;
        }
        // 보의 한쪽 끝부분 위에 있거나
        if (map[height][width][1]) {
            return true;
        }
        if (width > 0 && map[height][width - 1][1]) {
            return true;
        }
        // 다른 기둥위에 있어야한다.
        if (height > 0 && map[height - 1][width][0]) {
            return true;
        }
        return false;
    }

    private boolean isBuildTent(boolean[][][] map, int height, int width) {
        int maxWidth = map[0].length;
        // 보는 한쪽 끝 부분이 기둥 위에 있거나
        if (height > 0 && map[height - 1][width][0]) {
            return true;
        }
        if (height > 0 && width < maxWidth - 1 && map[height - 1][width + 1][0]) {
            return true;
        }
        // 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야한다.
        if (width > 0 && width < maxWidth - 1 && map[height][width - 1][1] && map[height][width + 1][1]) {
            return true;
        }

        return false;
    }

    private boolean check(boolean[][][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i][0] && !isBuildPillar(map, j, i)) return false;
                if (map[j][i][1] && !isBuildTent(map, j, i)) return false;
            }
        }
        return true;
    }
}
