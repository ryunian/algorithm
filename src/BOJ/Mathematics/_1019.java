package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1019 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 시작수
        int start = 1;
        // 미지막수
        int end = Integer.parseInt(br.readLine());
        // 자릿수
        int digit = 1;
        arr = new int[10];

        solve(start, end, digit);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    private static void solve(int start, int end, int digit) {
        while (start <= end) {
            // start를 0으로 맞춰준다.
            while (start % 10 != 0 && start <= end) {
                calc(start, digit);
                start++;
            }

            // end를 9로 맞춰준다.
            while (end % 10 != 9 && start <= end) {
                calc(end, digit);
                end--;
            }
            if (start > end) break;

            // 마지막 자리수를 제거
            start /= 10;
            end /= 10;


            for (int i = 0; i < 10; i++) {
                // (end - start + 1) 은 일의 자리에 0~9가 나타나는 횟수
                // ex) start = 10 , end = 39
                // 10 11 12 13 14 15 16 17 18 19
                // 20 21 22 23 24 25 26 27 28 29
                // 30 31 32 33 34 35 36 37 38 39
                // cnt = 30
                // 현재 자리수만큼 곱해줘야한다.
                arr[i] += (end - start + 1) * digit;
            }

            // 자리수를 높인다.
            digit *= 10;
        }
    }

    private static void calc(int num, int digit) {
        while (num > 0) {
            arr[num % 10] += digit;
            num /= 10;
        }
    }
}


