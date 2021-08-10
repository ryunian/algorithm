package programmers.Lv2;

public class N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = answer * arr[i] / gcb(answer, arr[i]);
        }
        return answer;
    }

    int gcb(int a, int b) {
        return b == 0 ? a : gcb(b, a % b);
    }
}