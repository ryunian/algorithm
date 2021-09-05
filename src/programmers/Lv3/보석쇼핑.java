package programmers.Lv3;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        보석쇼핑 test = new 보석쇼핑();
        test.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        test.solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        test.solution(new String[]{"XYZ", "XYZ", "XYZ"});
        test.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
    }

    public int[] solution(String[] gems) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Set<String> org = new HashSet<>();
        for (String str : gems) {
            org.add(str);
        }

        int[] answer = new int[2];
        int size = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (end < gems.length) {
            String str = gems[end];
            map.put(str, map.getOrDefault(str, 0) + 1);
            String tmp;
            while (map.get(tmp = gems[start]) != null && map.get(tmp) > 1 && start < end) {
                map.put(tmp, map.get(tmp) - 1);
                start++;
            }
            int length = end - start + 1;
            if (map.size() == org.size() && length < size) {
                size = length;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
            end++;
        }
        return answer;
    }
}
