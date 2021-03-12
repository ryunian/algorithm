package programmers.Lv3;

public class 풍성터트리기 {
    public static void main(String[] args) {
        풍성터트리기 test = new 풍성터트리기();
        test.solution(new int[]{9});
        test.solution(new int[]{9, -1});
        test.solution(new int[]{9, -1, -5});
        test.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33});
    }

    public int solution(int[] a) {
        int answer = 2;
        int length = a.length;

        // 최소값의 위치 탐색
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < length; i++) {
            if(min > a[i]){
                min = a[i];
                idx = i;
            }
        }
        // idx 가 처음과 끝이 나닐경우
        if(idx != 0 && idx != length-1) answer++;

        // 처음에서 idx 까지 탐색
        min = a[0];
        for (int i = 1; i < idx; i++) {
            if(min > a[i]) {
                answer++;
                min = a[i];
            }
        }

        // 끝에서 idx 까지 탐색
        min = a[length-1];
        for (int i = length - 1; i > idx; i--) {
            if(min > a[i]) {
                answer++;
                min = a[i];
            }
        }

        return length == 1 ? 1 : answer;
    }
}
