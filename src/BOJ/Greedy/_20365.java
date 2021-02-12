package BOJ.Greedy;

import java.util.Scanner;

public class _20365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int blue = str.charAt(0) == 'B' ? 1 : 0;
        int red = str.charAt(0) == 'R' ? 1 : 0;


        for (int i = 1; i < n; i++) {
            if(str.charAt(i-1) == str.charAt(i)) continue;
            if(str.charAt(i) == 'B') blue++;
            else red++;
        }
        if(blue > red){
            System.out.println(red+1);
        }else{
            System.out.println(blue+1);
        }
    }
}
