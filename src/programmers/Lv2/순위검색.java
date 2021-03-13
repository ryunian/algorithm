package programmers.Lv2;

import java.util.*;

public class 순위검색 {
    public static void main(String[] args) {
        순위검색 test = new 순위검색();
        String[] a = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] b = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 0"};
        test.solution(a, b);
    }

    Map<String, ArrayList<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] str = info[i].split(" ");
            makeGroup(str);
        }

        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
        }

        for (int i = 0; i < query.length; i++) {
            String[] str = query[i].replace(" and ", "").split(" ");

            if (map.get(str[0]) == null) {
                answer[i] = 0;
                continue;
            }
            ArrayList<Integer> tmp = map.get(str[0]);

            answer[i] = tmp.size() - lowerBound(Integer.parseInt(str[1]), tmp);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private void makeGroup(String[] str) {
        int score = Integer.parseInt(str[4]);
        recursion(new StringBuilder(), str, 0, score);
    }

    private void recursion(StringBuilder sb, String[] str, int idx, int score) {
        if (str.length - 1 == idx) {
            map.computeIfAbsent(sb.toString(), s -> new ArrayList<>()).add(score);
            return;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(sb).append(str[idx]);
        sb2.append(sb).append("-");
        recursion(sb1, str, idx + 1, score);
        recursion(sb2, str, idx + 1, score);
    }


    public int lowerBound(int val, ArrayList<Integer> list) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
