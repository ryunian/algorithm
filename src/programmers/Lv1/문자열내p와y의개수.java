package programmers.Lv1;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == 'p') p++;
            else if (x == 'y') y++;
        }

        if (p == y) return true;
        else return false;
    }
}
