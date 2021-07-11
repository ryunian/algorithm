package programmers.Lv4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 연결리스트 개념을 이용하여
// 해쉬맵에 가르키는 주소값 저장
public class 호텔방배정 {
    public static void main(String[] args) {
        호텔방배정 test = new 호텔방배정();
        test.solution(10, new long[]{1, 3, 4, 1, 3, 1});
        test.solution(10, new long[]{1, 1, 1, 1, 1, 1});
    }

    private long[] answer;
    private Map<Long, Long> map;
    public long[] solution(long k, long[] room_number) {
        answer = new long[room_number.length];
        map = new HashMap<>();


        for (int i = 0; i < room_number.length; i++) {
            long num = room_number[i];
            if (map.get(num) == null) {
                map.put(num, num + 1);
                answer[i] = num;
            } else {
                answer[i] = solve(num);
            }
        }
        return answer;
    }

    private long solve(long num) {
        ArrayList<Long> list = new ArrayList<>();
        dfs(num, list);

        long ret = list.get(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), ret + 1);
        }
        return ret;
    }

    private void dfs(long num, ArrayList<Long> list) {
        list.add(num);
        if (map.get(num) == null) {
            return;
        }
        dfs(map.get(num), list);
    }
}

