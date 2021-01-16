package JongManBook.Dynamic;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 8.2 와일드카드
public class WILDCARD {
    static String pat, str;
    static int[][] dp; // 메모이제이션

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            pat = sc.next();
            int n = sc.nextInt();
            // 파일의 이름을 알파벳순서로 출력하기 위한 우선순위큐
            PriorityQueue<String> q = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                str = sc.next();
                dp = new int[pat.length() + 1][str.length() + 1];
                for (int j = 0; j < dp.length; j++) {
                    Arrays.fill(dp[j], -1);
                }
                int res = solve(0, 0);
                if (res == 1) { // 1 = 패턴에 대응이 됬을 경우(true)
                    q.offer(str);
                }
            }
            // StringBuilder 생략
            while (!q.isEmpty()) System.out.println(q.poll());
        }
    }

    private static int solve(int a, int b) {
        int ret = dp[a][b];
        if (ret != -1) {
            return ret;
        }
        // 재귀로 각각의 패턴과 문자열을 비교해준다.
        if (b < str.length() && a < pat.length() && (pat.charAt(a) == '?' || pat.charAt(a) == str.charAt(b))) {
            return solve(a + 1, b + 1);
        }

        // 패턴끝에 도달해서 끝난 경우 문자열도 끝나야 한다.
        if (a == pat.length()) return dp[a][b] = (b == str.length() ? 1 : 0);

        // *를 만나서 끝난 경우 *에 몇글자를 대응해야할지 체크한다.
        if (pat.charAt(a) == '*') {
            if (solve(a + 1, b) == 1 || (b < str.length() && solve(a, b + 1) == 1)) {
                return dp[a][b] = 1;
            }
        }

        // 패턴에 대응이 되지않음
        return dp[a][b] = 0;
    }
}
/*
3
he?p
3
help
heap
helpp
*p*
3
help
papa
hello
*bb*
1
babbbc
 */