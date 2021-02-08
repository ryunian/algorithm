package BOJ.String;

import java.util.Scanner;

public class _2902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (65 <= x && x <= 90) {
                System.out.print(x);
            }
        }

    }
}
