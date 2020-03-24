package complete;

import java.util.Scanner;

public class _2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(y>=45){
            y -= 45;
        }else{
            y += 15;
            if(x==0){
                x = 23;
            }else{
                x--;
            }
        }
        System.out.println(x+" "+y);
    }
}
