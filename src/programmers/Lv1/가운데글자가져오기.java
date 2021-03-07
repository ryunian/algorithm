package programmers.Lv1;

public class 가운데글자가져오기 {
    public static void main(String[] args) {
        가운데글자가져오기 test = new 가운데글자가져오기();
        test.solution("a");
        test.solution("ab");
        test.solution("abc");
        test.solution("qwer");
        test.solution("abcde");
    }

    public String solution(String s) {
        int length = s.length();
        int mid = length / 2;

        String answer;
        if (length % 2 == 0) {
            answer = s.substring(mid - 1, mid + 1);
        } else {
            answer = s.substring(mid, mid + 1);
        }
        return answer;
    }
}
