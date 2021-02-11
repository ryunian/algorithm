package BOJ.String;

import java.util.Scanner;

public class _1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            String x = solve(n, 1);
            if(i != 0){
                for (int j = x.length(); j < 3; j++) {
                    sb.append(0);
                }
            }
            sb.append(x);
        }
        System.out.println(sb.toString());
    }

    private static String solve(int n, int digit) {
        int ret = 0;
        while (n > 0) {
            ret += n % 2 * digit;
            n /= 2;
            digit *= 10;
        }
        return ret + "";
    }
}
