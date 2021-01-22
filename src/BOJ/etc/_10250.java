package BOJ.etc;

import java.util.Scanner;
public class _10250 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int h,w,n,x,y;	
		for(int i=0; i<num; i++) {
			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			x = n/h +1;
			y = n%h;
			if(y==0) {
				x = n/h;
				y = h;
			}
			System.out.printf("%d%02d\n",y,x);
		}						
	}
}