package BOJ.Dynamic;

import java.util.Scanner;

public class _15881 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[] arr = sc.nextLine().toCharArray();
        char[] check = {'p', 'P', 'A', 'p'};

        int dp = 0;
        for (int i = 3; i < n; i++) {
            boolean chk = true;
            for (int j = 0; j < 4; j++) {
                if (arr[i - (3 - j)] != check[j]) {
                    chk = false;
                }
            }
            if (chk) {
                dp++;
                i += 3;
            }
        }
        System.out.println(dp);
    }
}
