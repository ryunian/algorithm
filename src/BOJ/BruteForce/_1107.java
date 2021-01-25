package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1107 {
    static int channel;
    // true : 부숴진 버튼
    static boolean[] button = new boolean[10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 원하는 채널
        channel = Integer.parseInt(br.readLine());
        // 부서진 버튼 수
        int breakBtn = Integer.parseInt(br.readLine());

        // breakBtn 값이 0이 들어올 수 있다.
        if(breakBtn != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (breakBtn-- > 0) {
                int x = Integer.parseInt(st.nextToken());
                button[x] = true;
            }
        }

        solve();
    }

    private static void solve() {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 1000000; i++) {
            // 숫자 i 가 숫자버튼으로 입력이 되는지 체크
            if (isPossible(i)) {
                // +- 누르는 횟수
                int abs = Math.abs(channel - i);
                // 숫자버튼 누른횟수
                int leng = String.valueOf(i).length();
                res = Math.min(res, abs + leng);
            }
        }

        // 현재채널에서 + or - 버튼을 눌러서 움직인것과 어느것이 작은지 비교
        res = Math.min(res, Math.abs(channel - 100));

        System.out.println(res);
    }


    private static boolean isPossible(int num) {
        // 0은 체크 할 수 없으므로 따로 체크
        if (num == 0) {
            return !button[num];
        }

        while (num > 0) {
            if (button[num % 10]) return false;
            num /= 10;
        }
        return true;
    }
}
