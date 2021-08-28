package programmers.Lv2;

import java.util.*;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        뉴스클러스터링 test = new 뉴스클러스터링();
        test.solution("FRANCE", "french");
        test.solution("handshake", "shake hands");
        test.solution("aa1+aa2", "AAAA12");
        test.solution("E=M*C^2", "e=m*c^2");
    }

    static double union, inter;
    static final int multi = 65536;
    static Set<String> set;
    static Map<String, Integer> map1, map2;

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        setting(str1, str2);

        if (inter == 0) return multi;

        double Jacquard = union / inter;
        int answer = (int) (Jacquard * 65536);
        return answer;
    }

    private void setting(String str1, String str2) {
        set = new HashSet<>();
        map1 = new HashMap<>();
        map2 = new HashMap<>();

        addToMap(str1, map1);
        addToMap(str2, map2);
        union = 0;
        inter = 0;

        for (String x : set) {
            if (map1.get(x) == null) {
                inter += map2.get(x);
            } else if (map2.get(x) == null) {
                inter += map1.get(x);
            } else {
                int a = map1.get(x);
                int b = map2.get(x);

                union += Math.min(a, b);
                inter += Math.max(a, b);
            }
        }
    }

    private void addToMap(String str1, Map<String, Integer> map) {
        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);
            if (a < 'a' || 'z' < a) continue;
            if (b < 'a' || 'z' < b) continue;

            String tmp = a + "" + b;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            set.add(tmp);
        }
    }
}
