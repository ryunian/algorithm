package programmers.Lv3;

import java.util.*;

public class 셔틀버스 {
    public static void main(String[] args) {
        셔틀버스 test = new 셔틀버스();
        test.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
        test.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"});
        test.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"});
        test.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"});
        test.solution(1, 1, 1, new String[]{"23:59"});
    }

    public String solution(int n, int t, int m, String[] timetable) {
        ArrayList<Integer> table = new ArrayList<>();
        for (int i = 0; i < timetable.length; i++) {
            table.add(toSec(timetable[i]));
        }
        Collections.sort(table);
        int time = toSec("09:00");
        int idx = 0;
        int cnt = 0;
        int lastTime = -1;
        while (n-- > 0) {
            cnt = 0;
            for (int j = 0; j < m; j++) {
                if (idx < table.size() && table.get(idx) <= time) {
                    lastTime = table.get(idx);
                    cnt++;
                    idx++;
                }
            }
            time += t;
        }
        if (cnt < m) {
            return toTime(time - t);
        }
        return toTime(lastTime - 1);
    }

    private int toSec(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    private String toTime(int time) {
        return String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
    }
}
