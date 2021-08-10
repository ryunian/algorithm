package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사칙연산 유효성 검사
// 틀린 코드 :
// 자식이 연산자면서 부모가 숫자인 경우만 체크하기 때문에 기타 예외에서 문제가 발생한다.
// 예외 :
// 1. 리프노드가 연산자일떄
// 2. 짝수일때 (해결함)
// 3. 입력에서 자식이 부모*2, 부모*2+1 이 아닐경우
public class _1233 {
    static int n;
    static String[] arr;
    static boolean isOk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new String[n + 1];
            isOk = true;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                String b = st.nextToken();
                arr[a] = b;
            }
            if(n % 2 == 0) isOk = false;

            solve(1);
            System.out.printf("#%d %d\n",tc, (isOk ? 1 : 0));
        }
    }

    private static void solve(int idx) {
        if (!isOk) return;
        if (idx > n) return;
        if (idx != 1 && isOperations(arr[idx]) && !isOperations(arr[idx / 2])) {
            isOk = false;
            return;
        }
        solve(idx * 2);
        solve(idx * 2 + 1);
    }

    private static boolean isOperations(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }
}
