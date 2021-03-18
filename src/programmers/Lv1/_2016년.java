package programmers.Lv1;

public class _2016년 {
    public static void main(String[] args) {
        _2016년 test = new _2016년();
        test.solution(5, 24); // 화
        test.solution(7, 13); // 수
        test.solution(12,25); // 일
    }

    private String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//    private String[] week = {"일", "월", "화", "수", "목", "금", "토"};
    private int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int first;
    public String solution(int a, int b) {
        first = 4;
        first += b;
        for (int i = 0; i < a - 1; i++) {
            first += month[i];
        }
        first %= 7;
//        System.out.println(week[first]);
        return week[first];
    }
}