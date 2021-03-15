package programmers.Lv3;

public class 합승택시요금 {
    public static void main(String[] args) {
        합승택시요금 test = new 합승택시요금();
        test.solution(6, 4, 6, 2,
                new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});

        test.solution(6, 4, 5, 6,
                new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}});


    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        int INF = 20000001;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = INF;
            }
        }
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            map[start][end] = cost;
            map[end][start] = cost;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        System.out.println(answer);

        return answer;
    }
}
