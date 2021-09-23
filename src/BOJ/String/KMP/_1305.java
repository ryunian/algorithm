package BOJ.String.KMP;

import java.util.Scanner;

// 광고
public class _1305 {
    static int n;
    static char[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = sc.next().toCharArray();

        int[] pi = makePi();
        System.out.println(n - pi[n-1]);
    }

    private static int[] makePi() {
        int[] pi = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (0 < j && arr[i] != arr[j]) {
                j = pi[j - 1];
            }
            if (arr[i] == arr[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
