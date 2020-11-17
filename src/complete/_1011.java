package complete;

import java.util.Scanner;

public class _1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			fly(x,y);
		}
	}

	private static void fly(int x, int y) {
		int distance = y-x;
		int n=1;
		while(true) {
			int pow = n*n;
			int min = pow - n + 1;
			int max = pow + n;
			if(min<=distance && distance<=max) {
				if(min<=distance && distance<=pow) {
					System.out.println(n*2-1);
				}else {
					System.out.println(n*2);
				}				
				break;
			}							
			n++;
		}
	}
}
