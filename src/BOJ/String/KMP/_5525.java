package BOJ.String.KMP;

import java.util.Scanner;

// IOIOI
// KMP 말고 다른 방법으로 푸는게 시간복잡도에서 더 유리함
public class _5525 {
    static char[] str, pattern;
    static int[] pi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();

        StringBuilder sb = new StringBuilder("I");
        String org = "OI";
        while (n-- > 0) {
            sb.append(org);
        }
        str = s.toCharArray();
        pattern = sb.toString().toCharArray();
        makePi();
        kmp();
    }

    private static void kmp() {
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            while (j > 0 && str[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (str[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    cnt++;
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void makePi() {
        pi = new int[pattern.length];
        for (int i = 2; i < pi.length; i++) {
            pi[i] = i-1;
        }
    }
}
