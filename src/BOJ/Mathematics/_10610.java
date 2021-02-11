package BOJ.Mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class _10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.nextLine().toCharArray();

        boolean useZero = false;
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            sum += ch[i] - '0';
            if(ch[i] == '0'){
                useZero = true;
            }
        }
        if(sum % 3 == 0 && useZero){
            StringBuilder sb = new StringBuilder();
            Arrays.sort(ch);
            for (int i = ch.length-1; i >= 0; i--) {
                sb.append(ch[i]);
            }
            System.out.println(sb.toString());
        }else {
            System.out.println(-1);
        }
    }
}
