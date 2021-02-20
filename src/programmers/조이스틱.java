package programmers;

public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 test = new 조이스틱();
//        test.solution("JEROEN");
//        test.solution("JAN");
//        test.solution("ABAAABAAAAAAAAABA");
//        test.solution("AAABAAAAB");

//        test.solution("CANAAAAANAN"); //48
//        test.solution("ABAAAAABAB"); //8
//        test.solution("AABAAAAAAABBB"); //11
//        test.solution("BBBBAAAABA"); // 12
    }

    public int solution(String name) {
        int answer = 0;
        int[] rl = new int[name.length()];
        int tmp = 0;
        int min = Integer.MAX_VALUE;

        // 오른쪽으로 간 다음 왼쪽으로 가는 경우
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                rl[tmp] = name.length() - i + tmp * 2;
                min = Math.min(min, rl[tmp]);
                tmp = i;
            }
        }
        // 오른쪽으로만 가는 경우
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                tmp = i;
            }
        }
        min = Math.min(min, tmp);

        // 왼쪽으로만 가는 경우
        for (int i = name.length() - 1; i >= 0; i--) {
            if (name.charAt(i) != 'A') {
                tmp = name.length() - i;
            }
        }
        min = Math.min(min, tmp);


        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') continue;
            if (name.charAt(i) - 'A' < 13) {
                answer += name.charAt(i) - 'A';
            } else {
                answer += 'Z' - name.charAt(i) + 1;
            }
        }
        System.out.println(answer + " " + min);

        return answer + min;
    }
}
