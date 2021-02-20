package programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    public static void main(String[] args) {
        소수찾기 test = new 소수찾기();
        test.solution("123");
    }

    boolean[] sosu, visit;
    Set<Integer> set;

    public int solution(String numbers) {
        set = new HashSet<>();
        visit = new boolean[numbers.length()];
        sosu = new boolean[10000000];
        sosu[0] = sosu[1] = true;

        for (int i = 2; i < sosu.length; i++) {
            if (sosu[i]) continue;
            for (int j = i + i; j < sosu.length; j += i) {
                sosu[j] = true;
            }
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (i == 0 && numbers.charAt(i) == '0') continue;
            if (!visit[i]) {
                visit[i] = true;
                solve(numbers.charAt(i) + "", i, numbers);
                visit[i] = false;
            }
        }

        return set.size();
    }

    private void solve(String s, int idx, String origin) {
        if (!sosu[Integer.parseInt(s)]){
            set.add(Integer.parseInt(s));
        }

        for (int i = 0; i < origin.length(); i++) {
            if (!visit[i] && idx != i) {
                visit[i] = true;
                solve(s + origin.charAt(i), i, origin);
                visit[i] = false;
            }
        }
    }
}
