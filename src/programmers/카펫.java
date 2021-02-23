package programmers;

public class 카펫 {
    public static void main(String[] args) {
        카펫 test = new 카펫();
        test.solution(10, 2);
        test.solution(8, 1);
        test.solution(24, 24);
        test.solution(50, 22);
        test.solution(2996, 497004);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        loop :
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= i; j++) {
                if (i * j == sum && (i + j) * 2 - 4 == brown) {
                    answer[0] = i;
                    answer[1] = j;
                    break loop;
                }
            }
        }
        return answer;
    }
}
