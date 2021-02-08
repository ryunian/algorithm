package BOJ.String;

import java.util.Scanner;

public class _10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alpha = new int[26];
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alpha.length; i++) {
            sb.append(alpha[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
