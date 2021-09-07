package programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {
    public static void main(String[] args) {

    }

    int[] arr = {781, 156, 31, 6, 1};
    public int solution(String word) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);

        int answer = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);

            if(c == 'A'){
                answer++;
            }else {
                answer += map.get(c) * arr[i] + 1;
            }
        }
        return answer;
    }
}
