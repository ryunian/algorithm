package BOJ.Implementation;

import java.util.Scanner;

// 영식이와 친구들
public class _1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];
        int x = 0;
        int cnt = 0;
        while (true) {
            if (++arr[x] == m) break;

            if (arr[x] % 2 == 0) {
                x = x - l + n;
                x %= n;
            } else {
                x = x + l + n;
                x %= n;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
