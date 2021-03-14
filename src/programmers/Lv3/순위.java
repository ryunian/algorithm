package programmers.Lv3;

import java.util.Arrays;

public class 순위 {
    public static void main(String[] args) {
        순위 test = new 순위();
        test.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}); //2
//        test.solution(7, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}, {5, 6}, {6, 7}}); //4
//        test.solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}}); // 6
//        test.solution(5, new int[][]{{1, 4}, {4, 2}, {2, 5}, {5, 3}}); // 5
//        test.solution(5, new int[][]{{3, 5}, {4, 2}, {4, 5}, {5, 1}, {5, 2}}); // 1
//        test.solution(3, new int[][]{{1, 2}, {1, 3}});// 1
//        test.solution(6, new int[][]{{1, 6}, {2, 6}, {3, 6}, {4, 6}}); // 0
//        test.solution(8, new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}); // 0
//        test.solution(9, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {6, 1}, {7, 1}, {8, 1}, {9, 1}});// 1
//        test.solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {2, 4}, {2, 6}}); // 6
//        test.solution(4, new int[][]{{4, 3}, {4, 2}, {3, 2}, {3, 1}, {4, 1}, {2, 1}}); // 4
//        test.solution(3, new int[][]{{3, 2}, {3, 1}}); // 1
//        test.solution(4, new int[][]{{1, 2}, {1, 3}, {3, 4}}); // 1
    }

    public int solution(int n, int[][] results) {
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], false);
        }
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            map[win][lose] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // j 에서 i 를 통해 k 로 가는 경로가 true 일 경우
                    // j 에서 k 는 통행이 가능하다.
                    if (map[j][i] && map[i][k]) {
                        map[j][k] = true;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            boolean isOk = true;
            for (int j = 1; j <= n; j++) {
                // 자기자신 제외
                if (i == j) continue;

                // 하나라도 일방통행이 아닐시 순위를 알수가 없다.
                if (map[i][j] == map[j][i]) {
                    isOk = false;
                }
            }
            if (isOk) answer++;
        }
        return answer;
    }

}