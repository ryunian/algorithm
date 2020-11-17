package complete;

import java.util.Scanner;

public class _2581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int sum = 0;
		int min = 10000;		
		for(int i=x; i<=y; i++) {
			int sosu = 0;
			for(int j=1; j<=i; j++) {
				if(i>1 && i%j == 0) {
					sosu++;
				}
				if(sosu>2) break;
				if(i==j && sosu==2) {
					sum += j;
					if(j<min) min = j;
				}
			}
		}
		if(sum==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum+"\n"+min);
		}
	}
}
