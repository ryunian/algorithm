package BOJ.Greedy;

import java.util.Scanner;

public class _1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[10];

        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            num[str.charAt(i) - '0']++;
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            int numCnt;
            if (i == 6) {
                numCnt = (num[6] + num[9]) / 2;
                numCnt += (num[6] + num[9]) % 2 == 0 ? 0 : 1;
            } else {
                numCnt = num[i];
            }
            max = Math.max(max, numCnt);
        }
        System.out.println(max);
    }
}
