package programmers;

public class 괄호변환 {
    public static void main(String[] args) {
        괄호변환 test = new 괄호변환();
        System.out.println(test.solution("()))((()"));
        System.out.println(test.solution("(()())()"));
    }


    public String solution(String p) {
        if (p.length() == 0) return "";

        String u = p.substring(0, balance(p) + 1);
        String v = p.substring(balance(p) + 1, p.length());

        if(correct(u)){
            return u + solution(v);
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(solution(v)).append(")");
            return sb.append(reverse(u.substring(1, u.length()-1))).toString();
        }
    }

    private char[] reverse(String str) {
        char[] res = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res[i] = str.charAt(i) == ')' ? '(' : ')';
        }
        return res;
    }

    public int balance(String str) {
        int left = str.charAt(0) == '(' ? 1 : 0;
        int right = str.charAt(0) == ')' ? 1 : 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                return i;
            }
        }
        return str.length();
    }

    public boolean correct(String str) {
        while (str.length() > 0 && str.indexOf("()") > -1){
            str = str.replace("()", "");
        }
        if(str.length() == 0){
            return true;
        }else{
            return false;
        }
    }
}

// 07 44