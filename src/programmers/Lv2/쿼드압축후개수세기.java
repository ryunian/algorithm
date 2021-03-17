package programmers.Lv2;

public class 쿼드압축후개수세기 {
    public static void main(String[] args) {
        쿼드압축후개수세기 test = new 쿼드압축후개수세기();
        test.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        test.solution(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}}
        );

    }

    private int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        int n = arr.length;
        solve(arr, 0, 0, n);

        return answer;
    }

    private void solve(int[][] arr, int row, int col, int size) {
        if (isSame(arr, row, col, size)) {
            answer[arr[row][col]]++;
        } else {
            int division = size / 2;
            solve(arr, row, col, division);
            solve(arr, row, col + division, division);
            solve(arr, row + division, col, division);
            solve(arr, row + division, col + division, division);
        }
    }


    private boolean isSame(int[][] arr, int row, int col, int size) {
        int x = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (x != arr[i][j]) return false;
            }
        }
        return true;
    }
}
