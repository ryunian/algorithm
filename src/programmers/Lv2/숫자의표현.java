package programmers.Lv2;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = left;
        int sum = 1;
        while (left <= n) {
            if (sum == n) {
                answer++;
                sum -= left;
                left++;
            } else if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        // System.out.println(answer);

        return answer;
    }
}
