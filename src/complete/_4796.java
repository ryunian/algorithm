package complete;

import java.util.Scanner;

public class _4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseNum = 1;
        while (true) {
            int L = sc.nextInt(); // 사용가능 일
            int P = sc.nextInt(); // 연속하는 x일
            int V = sc.nextInt(); // 휴가 기간

            if (L == 0 && P == 0 && V == 0) break;

            int x = V / P * L;
            int y = V % P > L ? L : V % P;
            int result = x + y;
            System.out.println("Case " + caseNum + ": " + result);
            caseNum++;
        }
    }
}
