package programmers.Lv3;

public class 가장긴팰린드롬 {
    public static void main(String[] args) {
        가장긴팰린드롬 test = new 가장긴팰린드롬();
        System.out.println(test.solution("abcdcba"));
        System.out.println(test.solution("abacde"));
        System.out.println(test.solution(""));
        System.out.println(test.solution("a"));
        System.out.println(test.solution("ab"));
        System.out.println(test.solution("aa"));
        System.out.println(test.solution("abcde"));
        System.out.println(test.solution("abaabaaaaaaa")); // 7

    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, palindrome(s, i - 1, i + 1, 1));
            answer = Math.max(answer, palindrome(s, i, i + 1, 0));
        }
        return answer;
    }

    private int palindrome(String s, int left, int right, int cnt) {
        while (0 <= left && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                cnt += 2;
            } else {
                break;
            }
            left--;
            right++;
        }
        return cnt;
    }
}
