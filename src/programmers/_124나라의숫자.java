package programmers;

public class _124나라의숫자 {
    public static void main(String[] args) {
        _124나라의숫자 test = new _124나라의숫자();
        for (int i = 1; i < 20; i++) {
            test.solution(i);
        }
        test.solution(500000001);
    }

    static StringBuilder sb;

    public String solution(int n) {
        sb = new StringBuilder();
        // mod 3 이 0일 떄
        if (n % 3 == 0) {
            solve(n, true);
        } else {
            // mod 3 이 0 이 아닐떄
            solve(n, false);
        }
        System.out.println(sb);
        return sb.toString();
    }

    private void solve(int n, boolean isDiv3) {
        if (n == 0) {
            return;
        }
        if (isDiv3) {
            n /= 3;
            n--;
            sb.insert(0, 4);
        } else if (!isDiv3) {
            int tmp = n % 3;
            n /= 3;
            sb.insert(0, tmp);
        }
        if (n % 3 == 0) {
            solve(n, true);
        } else {
            solve(n, false);
        }
    }
}