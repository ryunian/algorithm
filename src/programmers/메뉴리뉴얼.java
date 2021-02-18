package programmers;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        메뉴리뉴얼 test = new 메뉴리뉴얼();
        test.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        test.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        test.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
//        test.solution(new String[]{"XYZ", "XWY", "WXA", "ABC", "BC", "AA"}, new int[]{1});
    }

    static boolean[] visit;
    static Map<String, Integer> map;
    static int maxCnt;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            maxCnt = 0;
            for (int j = 0; j < orders.length; j++) {
                visit = new boolean[orders[j].length()];
                char[] c = orders[j].toCharArray();
                Arrays.sort(c);
                solve("", 0, c, course[i]);
            }
            for(String x : map.keySet()){
                if(map.get(x) != 1 && map.get(x) == maxCnt){
                    list.add(x);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list);
        return list.toArray(new String[list.size()]);
    }

    private void solve(String str, int idx, char[] origin, int max) {
        if (str.length() == max) {
            if (map.get(str) != null) {
                int tmp = map.get(str);
                map.put(str, tmp + 1);
            } else {
                map.put(str, 1);
            }
            maxCnt = Math.max(map.get(str), maxCnt);
            return;
        }

        for (int i = idx; i < origin.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                solve(str + origin[i], i + 1, origin, max);
                visit[i] = false;
            }
        }
    }

}
