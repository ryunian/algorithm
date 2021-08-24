package BOJ.KMP;

import java.util.Arrays;
import java.util.Scanner;

// 부분 문자열
public class _16916 {
    static int[] pi;
    static char[] str, pattern;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().toCharArray();
        pattern = sc.nextLine().toCharArray();

        makePi();
        System.out.println(Arrays.toString(pi));
        kmp();
    }

    private static void kmp() {
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            while (0 < j && str[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (str[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    System.out.println(1);
                    return;
                } else {
                    j++;
                }
            }
        }

        System.out.println(0);
    }

    private static void makePi() {
        pi = new int[pattern.length];
        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (0 < j && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
            }
        }
    }
}