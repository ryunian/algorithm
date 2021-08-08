package programmers.Lv2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        영어끝말잇기 test = new 영어끝말잇기();
        test.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        test.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        test.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char prev = words[0].charAt(words[0].length() - 1);

        int idx = 1;
        while (idx < words.length) {
            String str = words[idx];
            if (set.contains(str) || prev != str.charAt(0)) {
                break;
            }
            prev = str.charAt(str.length() - 1);
            set.add(str);
            idx++;
        }

        if(idx < words.length){
            answer[0] = idx % n + 1;
            answer[1] = idx / n + 1;
        }
        return answer;
    }
}

