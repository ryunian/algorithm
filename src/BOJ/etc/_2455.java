package BOJ.etc;

import java.util.Scanner;

public class _2455 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int y = 0;
		for(int i=0;i<4;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			x = x - a + b;
			if(y<x) y = x;
		}
		System.out.println(y);
	}
}
