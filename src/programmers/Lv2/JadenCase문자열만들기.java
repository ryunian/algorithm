package programmers.Lv2;

public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        JadenCase문자열만들기 test = new JadenCase문자열만들기();
        test.solution("3people unFollowed me");
        test.solution("for the last week");
    }

    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i - 1] == ' ') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }

        return new String(arr);
    }
}