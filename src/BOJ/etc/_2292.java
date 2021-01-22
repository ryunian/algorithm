package BOJ.etc;

import java.util.Scanner;

public class _2292 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);		
		int a = sc.nextInt();
		int x= 1;
		int y= 1;
		int result = 1;
		for(int i=1;i<=a;i++){
			if(i==x+y){				
				x = x+y;
				y = 6 * result;
				result++;
			}
		}
		System.out.println(result);
		
	}
}
