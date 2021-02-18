package programmers;

import java.util.Arrays;

public class 삼각달팽이 {
    public static void main(String[] args) {
        삼각달팽이 test = new 삼각달팽이();
        test.solution(4);
        test.solution(5);
    }

    static int num = 1, max;
    static int[] arr;

    public int[] solution(int n) {
        max = 0;
        for (int i = 1; i <= n; i++) {
            max += i;
        }
        arr = new int[max];
        arr[0] = num++;
        solve(0, 1, 1);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private void solve(int idx, int tmp, int direction) {
        if (num == max + 1) {
            return;
        }

        if (direction == 1) {
            while (idx + tmp < max && arr[idx + tmp] == 0) {
                arr[idx + tmp] = num++;
                idx += tmp;
                tmp++;
            }
            solve(idx + 1, tmp, 2);

        } else if (direction == 2) {
            while (idx < max && arr[idx] == 0) {
                arr[idx++] = num++;
            }
            solve(idx - 1, tmp, 3);

        } else if (direction == 3) {
            while (arr[idx - tmp] == 0) {
                arr[idx - tmp] = num++;
                idx -= tmp;
                tmp--;
            }
            solve(idx, tmp, 1);

        }
    }
}
