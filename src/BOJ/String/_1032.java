package BOJ.String;

import java.util.Scanner;

public class _1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] a = sc.next().toCharArray(); n--;
        while (n-- > 0 ){
            char[] b = sc.next().toCharArray();
            for (int i = 0; i <a.length ; i++) {
                if(a[i] == '?') continue;
                else if(a[i] != b[i]) a[i] = '?';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }
}
