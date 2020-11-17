package complete;

import java.util.Scanner;

public class _5585 {
    public static void main(String[] args) {
        int[] money = {500,100,50,10,5,1};
        Scanner sc = new Scanner(System.in);
        int n = 1000 - sc.nextInt();
        int count = 0;
        for(int x : money){
            if(n == 0) break;
            if(n/x > 0){
                count += n/x;
                n %= x;
            }
        }
        System.out.println(count);
    }
}
