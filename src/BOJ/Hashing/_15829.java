package BOJ.Hashing;

import java.util.Scanner;

// Hashing
public class _15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int sosu = 31;
        int mod = 1234567891;
        long res = 0;
        for (int i = 0; i < n; i++) {
            long x = str.charAt(i) - 'a' + 1;
            long y = 1;
            for (int j = 0; j < i; j++) {
                y *= sosu;
                y %= mod;
            }
            res += x * y;
            res %= mod;
        }
        System.out.println(res % mod);
    }
}
