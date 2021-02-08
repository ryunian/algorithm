package BOJ.String;

import java.util.Scanner;

public class _1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String str = sc.next();
            for (int j = i%2; j < 8; j+=2) {
                if(str.charAt(j) == 'F') cnt++;
            }
        }
        System.out.println(cnt);
    }
}
