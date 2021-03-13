package programmers.Lv3;

public class 입국심사 {
    public static void main(String[] args) {
        입국심사 test = new 입국심사();
        test.solution(6, new int[]{7, 10});
    }

    public long solution(int n, int[] times) {
        long min = Long.MAX_VALUE;
        for (int x : times) {
            min = Math.min(min, x);
        }
        long start = min;
        long end = min * n;
        long answer = end;

        while (start <= end) {
            long mid = (start + end) / 2;
            long check = 0;
            for (int time : times) {
                check += mid / time;
            }
            if (check < n) {
                start = mid + 1;
            } else if(check >= n){
                answer = mid;
                end = mid - 1;
            }
        }

        return answer;
    }
}
