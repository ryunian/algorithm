package programmers;

import java.util.Arrays;

public class 숫자게임 {
    public static void main(String[] args) {
        숫자게임 test = new 숫자게임();
        System.out.println(test.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(test.solution(new int[]{2, 2, 2, 2}, new int[]{1,1,1,1}));
        System.out.println(test.solution(new int[]{2, 3, 4, 5, 6, 7}, new int[]{7, 6, 5, 4, 3, 2}));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        int win = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = idx; j < B.length; j++) {
              if (A[i] < B[j]) {
                    win++;
                    idx = j + 1;
                    break;
                }
            }
        }

        return win;
    }
}
