package JongManBook.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class CLOCKSYNC {
    private static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
    // 버튼 연결 정보
    private static int[][] button = {
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            int[] arr = new int[16];
            for (int i = 0; i < 16; i++) {
                arr[i] = sc.nextInt();
            }
            int result = solve(arr, 0);
            System.out.println(result == INF ? -1 : result);
        }
    }

    // 버튼을 swtch번 누르는 메소드
    private static void push(int[] clocks, int swtch) {
        for (int i = 0; i < CLOCKS; i++) {
            if(button[swtch][i] == 1){
                clocks[i] += 3;
                clocks[i] %= 12;
            }
        }
    }

    private static int solve(int[] clock, int swtch) {
        // 시계가 전부 12시(0시)를 향하는지 체크
        boolean check = Arrays.stream(clock).allMatch(o -> o%12 == 0);

        if (swtch == SWITCHES) {
            return check ? 0 : INF;
        }
        int ret = INF;
        for (int cnt = 0; cnt < 4; cnt++) {
            ret = Math.min(ret, cnt + solve(clock, swtch + 1));
            push(clock, swtch);
        }
        // push를 4번 누를 경우 원래 상태가 된다.
        return ret;
    }
}
