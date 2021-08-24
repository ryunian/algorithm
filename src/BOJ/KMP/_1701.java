package BOJ.KMP;

import java.util.Arrays;
import java.util.Scanner;

// Cubeditor
public class _1701 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int length = str.length();
        int[] pi = new int[length];
        int res = 0;

        for (int i = 0; i < length; i++) {
            int matches = 0;
            String tmp = str.substring(i, length);
            Arrays.fill(pi, 0);

            for (int j = 1; j < tmp.length(); j++) {
                while (0 < matches && tmp.charAt(matches) != tmp.charAt(j)) {
                    matches = pi[matches - 1];
                }

                if (tmp.charAt(matches) == tmp.charAt(j)) {
                    pi[j] = ++matches;
                    res = Math.max(res, pi[j]);
                }
            }
        }
        System.out.println(res);
    }
}