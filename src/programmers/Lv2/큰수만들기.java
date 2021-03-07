package programmers.Lv2;

public class 큰수만들기 {
    public static void main(String[] args) {
        큰수만들기 test = new 큰수만들기();
        test.solution("1924", 2);
        test.solution("1231234", 3);
        test.solution("4177252841", 4);
    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        if(number.charAt(0) == '0') return "0";
        // 삭제하지 않아야할수 만큼 반복
        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for (int j = idx; j <= k + i; j++) {
                char n = number.charAt(j);
                if (max < n) {
                    idx = j + 1;
                    max = n;
                }
                if (n == 9) break;
            }
            sb.append(max);

        }
        return sb.toString();
    }
}
