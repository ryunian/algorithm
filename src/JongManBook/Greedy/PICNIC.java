package JongManBook.Greedy;

import java.util.Scanner;

// 6.4 소풍
public class PICNIC {
    static int n;
    static boolean[] taken;
    static boolean[][] friends;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            n = sc.nextInt(); // 학생의 수
            int m = sc.nextInt(); // 친구 쌍의 수
            taken = new boolean[n];

            friends = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                friends[a][b] = friends[b][a] = true;
            }
            System.out.println(solve());
        }
    }

    private static int solve() {
        // 학생의 짝이 다 지어졌을 경우
        int firstFree = -1;
        for (int i = 0; i < n; ++i) {
            if (!taken[i]) {
                firstFree = i;
                break;
            }
        }
        if (firstFree == -1) return 1;

        int ret = 0;
        for (int i = firstFree + 1; i < n; ++i) {
            if (!taken[i] && friends[firstFree][i]) {
                taken[firstFree] = taken[i] = true;
                ret += solve();
                taken[firstFree] = taken[i] = false;
            }
        }
        return ret;
    }
}
