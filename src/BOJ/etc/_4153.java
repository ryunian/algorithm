package BOJ.etc;

import java.util.Scanner;

public class _4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = 0;
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(c<a){
				f = a;
				a = c;
				c = f;
			}
			if(c<b){
				f = b;
				b = c;
				c = f;
			}
			if(a==0 & b==0 & c==0) break;
			if(Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2)){
				System.out.println("right");
			}else System.out.println("wrong");
			
		}
	}

}
