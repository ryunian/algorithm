package programmers.Lv3;

public class N으로표현 {
    public static void main(String[] args) {
        N으로표현 test = new N으로표현();
        test.solution(5, 12);
        test.solution(2, 11);
    }

    int N;
    int res;

    public int solution(int N, int number) {
        res = 9;
        this.N = N;
        solve(0, 0, number);
        return res == 9 ? -1 : res;
    }

    public void solve(int cnt, int sum, int number) {
        if (cnt > 8) {
            return;
        }
        if (sum == number) {
            res = Math.min(res, cnt);
            return;
        }

        int n = 0;
        for (int i = 0; i < 8; i++) {
            n = n * 10 + N;
            solve(cnt + 1 + i, sum + n, number);
            solve(cnt + 1 + i, sum - n, number);
            solve(cnt + 1 + i, sum * n, number);
            solve(cnt + 1 + i, sum / n, number);
        }
    }
}
