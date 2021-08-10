package programmers.Lv2;

import java.util.Arrays;

public class 최솟값만들기 {
    public int solution(int []A, int []B){
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int left = 0;
        int right = B.length-1;
        while(left < A.length){
            answer += A[left] * B[right];
            left++;
            right--;
        }
        return answer;
    }
}
