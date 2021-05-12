package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _16890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr1 = br.readLine().toCharArray();
        char[] charArr2 = br.readLine().toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        int size = charArr1.length;
        char[] newArr = new char[size];

        int start1 = 0, end1 = (size - 1) / 2;
        int start2 = (size + 1) / 2, end2 = size - 1;
        int ansStart = 0, ansEnd = size - 1;

        int flag = 1;
        while (size > 0) {
            // 구사과
            if (flag == 1) {

                if (charArr1[start1] < charArr2[end2]) {
                    // 구사과의 최소값이 큐브러버의 최대값보다 작다면
                    // 가장 맨앞에 삽입한다.
                    newArr[ansStart++] = charArr1[start1++];
                } else {
                    // 구사과의 최소값이 큐브러버의 최소값보다 크다면
                    // 가장 맨뒤에 삽입한다.
                    newArr[ansEnd--] = charArr1[end1--];
                }
            }
            // 큐브러버
            else {
                if (charArr2[end2] > charArr1[start1]) {
                    // 큐브러버의 최대값이 구사과의 최소값보다 크다면
                    // 가장 맨앞에 삽입한다.
                    newArr[ansStart++] = charArr2[end2--];
                } else {
                    // 큐브러버의 최대값이 구사과의 최소값보다 작다면
                    // 최소값을 맨뒤에 삽입한다.
                    newArr[ansEnd--] = charArr2[start2++];
                }
            }
            flag *= -1;
            size--;

        }
        System.out.println(new String(newArr));
    }
}
