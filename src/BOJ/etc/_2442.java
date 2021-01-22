package BOJ.etc;

import java.util.Scanner;

public class _2442 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = a;
		String x = "*";
		for(int i=0;i<a;i++){
			for(int j=1;j<b;j++){
				System.out.print(" ");
			}			
			System.out.println(x);
			b--;
			x = x+"**";
		}
	}
}
