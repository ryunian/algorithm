package programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 압축 {
    public static void main(String[] args) {
        압축 test = new 압축();
        test.solution("KAKAO");
        test.solution("TOBEORNOTTOBEORTOBEORNOT");
        test.solution("ABABABABABABABAB");
    }

    Map<String, Integer> map;

    public int[] solution(String msg) {
        init();
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int num = 27;
        while (idx < msg.length()) {
            sb.setLength(0);
            sb.append(msg.charAt(idx));
            while (++idx < msg.length()) {
                sb.append(msg.charAt(idx));
                if(map.get(sb.toString()) == null){
                    map.put(sb.toString(), num++);
                    sb.setLength(sb.length() - 1);
                    break;
                }
            }
            list.add(map.get(sb.toString()));
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    private void init() {
        map = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), c - 'A' + 1);
        }
    }
}