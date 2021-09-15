package BOJ.Mathematics.MillerRabin;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

// 소-난다!
// 밀러-라빈 소수 판별법 (Miller-Rabin Primality Test)
public class _19699 {
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static boolean[] sosu;
    static TreeSet<Integer> res;
    // int 범위
    static int[] prime = {2, 7, 61};
    // long 범위
    // static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        res = new TreeSet<>();
        visit = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solve(0, 0, 0);

        if (res.isEmpty()) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = res.iterator();
        while (it.hasNext()) {
            sb.append(it.next() + " ");
        }
        System.out.print(sb.toString());
    }

    private static void solve(int idx, int cnt, int sum) {
        if (cnt == m) {
            boolean isSosu = true;
            for (int sosu : prime) {
                if (!miller(sum, sosu)) {
                    isSosu = false;
                    break;
                }
            }
            if (isSosu) res.add(sum);
            return;
        }
        for (int i = idx; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            solve(i, cnt + 1, sum + arr[i]);
            visit[i] = false;
        }
    }

    private static boolean miller(long n, long a) {
        if (n <= 1) return false;
        if (a % n == 0) return true;
        long k = n - 1;
        while (true) {
            long tmp = power(a, k, n);
            if (tmp == n - 1) return true; // a^k = -1 (mod n)
            if (k % 2 == 1) return (tmp == 1 || tmp == n - 1);
            k /= 2;
        }
    }

    private static long power(long x, long y, long mod) {
        long res = 1;
        x %= mod;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % mod;
            y /= 2;
            x = (x * x) % mod;
        }
        return res;
    }
}
