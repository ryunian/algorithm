package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사칙연산 유효성 검사
public class _1233_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            boolean isOk = true;
            int n = Integer.parseInt(br.readLine());
            // 짝수일경우 계산이 불가능하다.
            if (n % 2 == 0) isOk = false;

            for (int i = 0; i < n / 2; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                String value = st.nextToken();

                // 자식이 없거나 연산자가 아니라면 계산이 불가능하다.
                if (st.countTokens() != 2 || !isOperations(value)) {
                    isOk = false;
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    // 자식의 인덱스가 올바른지 체크
                    if (!childCheck(parent, a) || !childCheck(parent, b)) {
                        isOk = false;
                    }
                }
            }

            // 리프노드
            for (int i = n / 2; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String value = st.nextToken();

                // 자식이 있거나 연산자라면 계산이 불가능하다.
                if (st.hasMoreTokens() || isOperations(value)) {
                    isOk = false;
                }
            }
            System.out.printf("#%d %d\n", tc, (isOk ? 1 : 0));
        }
    }

    public static boolean childCheck(int parent, int child) {
        if (parent * 2 == child || parent * 2 + 1 == child) {
            return true;
        }
        return false;
    }

    private static boolean isOperations(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }
}
