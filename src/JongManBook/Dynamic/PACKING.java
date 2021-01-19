package JongManBook.Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 9.2 여행 짐 싸기
public class PACKING {
    private static int n, w;
    private static String[] name;
    private static int[] volume, need;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            n = sc.nextInt(); // 물건 수
            w = sc.nextInt(); // 무게제한
            name = new String[100];
            volume = new int[100];
            need = new int[100];
            for (int i = 0; i < n; i++) {
                name[i] = sc.next();
                volume[i] = sc.nextInt();
                need[i] = sc.nextInt();
            }

            dp = new int[1001][100];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            ArrayList<String> list = new ArrayList<>();

            int res = solve(w, 0);
            find(w, 0, list);

            // 출력
            System.out.println(res + " "+ list.size());
            for(String x : list){
                System.out.println(x);
            }
        }
    }

    // capacity : 남은 용량
    // item : 현재 담을 물건의 index
    private static int solve(int capacity, int item) {
        if (item == n) return 0;

        int ret = dp[capacity][item];
        if (ret != -1) return ret;

        // 이 물건을 담을 경우
        ret = solve(capacity, item + 1);

        // 이 물건을 담지 않을 경우
        if (capacity >= volume[item]) {
            ret = Math.max(ret,
                    solve(capacity - volume[item], item + 1) + need[item]);
        }

        return dp[capacity][item] = ret;
    }

    // 답추적
    private static void find(int capacity, int item, ArrayList<String> list) {
        if (item == n) return;

        // 두 값이 같다면 item을 선택하지 않고도 최대 절박도를 얻을수 있음
        if (solve(capacity, item) == solve(capacity, item + 1)) {
            find(capacity, item + 1, list);
        } else {
            // 선택을 해야 절박도를 얻을 수 있으므로,
            // 리스트에 물건을 추가
            list.add(name[item]);
            find(capacity - volume[item], item + 1, list);
        }
    }
}
/*
2
6 10
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
6 17
laptop 4 7
camera 2 10
xbox 6 6
grinder 4 7
dumbell 2 5
encyclopedia 10 4
 */