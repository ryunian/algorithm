package programmers.Lv2;

public class 상호평가 {
    public static void main(String[] args) {
        상호평가 test = new 상호평가();
        test.solution(new int[][]{{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}});
        test.solution(new int[][]{{50, 90}, {50, 87}});
    }

    public String solution(int[][] scores) {
        int n = scores.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minCnt = 0;
            int max = Integer.MIN_VALUE;
            int maxCnt = 0;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int val = scores[j][i];
                if (min > val) {
                    minCnt = 1;
                    min = val;
                } else if (min == val) {
                    minCnt++;
                }
                if (max < val) {
                    maxCnt = 1;
                    max = val;
                } else if (max == val) {
                    maxCnt++;
                }
                sum += val;
            }

            int tmp = scores[i][i];
            if ((tmp == min && minCnt == 1) || (tmp == max && maxCnt == 1)) {
                sb.append(solve(sum - tmp, n - 1));
            } else {
                sb.append(solve(sum, n));
            }
        }
        return sb.toString();
    }

    private String solve(int sum, int n) {
        double score = (double) sum / n;
        if (90 <= score) return "A";
        else if (80 <= score && score < 90) return "B";
        else if (70 <= score && score < 80) return "C";
        else if (50 <= score && score < 70) return "D";
        else return "F";
    }
}
