package SWEA.D3;

import java.util.Scanner;

// 안경이 없어!
public class _7272 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String str1 = sc.next();
            String str2 = sc.next();
            if(str1.length() != str2.length()){
                System.out.printf("#%d DIFF\n", tc);
                continue;
            }

            int a = 0;
            int b = 0;
            boolean check = true;
            for (int i = 0; i < str1.length(); i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if (c1 == 'A' || c1 == 'D' || c1 == 'O' || c1 == 'P' || c1 == 'Q' || c1 == 'R') {
                    a = 1;
                } else if (c1 == 'B') {
                    a = 2;
                }
                if (c2 == 'A' || c2 == 'D' || c2 == 'O' || c2 == 'P' || c2 == 'Q' || c2 == 'R') {
                    b = 1;
                } else if (c2 == 'B') {
                    b = 2;
                }
                if(a != b){
                    check = false;
                    break;
                }

            }
            if (check) {
                System.out.printf("#%d SAME\n", tc);
            } else {
                System.out.printf("#%d DIFF\n", tc);
            }
        }
    }
}
