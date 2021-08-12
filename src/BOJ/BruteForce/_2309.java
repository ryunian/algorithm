package BOJ.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

// 일곱 난쟁이
public class _2309 {
    static int m = 9;
    static int[] arr = new int[m];
    static boolean[] visit = new boolean[m];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        solve(0);
    }

    private static void solve(int idx) {
        if (idx == m) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (visit[i]) {
                    sum += arr[i];
                    cnt++;
                }
            }
            if(cnt == 7 && sum == 100){
                for (int i = 0; i < m; i++) {
                    if (visit[i]) {
                        System.out.println(arr[i]);
                    }
                }
                System.exit(0);
            }
            return;
        }
        visit[idx] = true;
        solve(idx + 1);
        visit[idx] = false;
        solve(idx + 1);
    }
}