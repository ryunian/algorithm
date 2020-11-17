package complete;

import java.util.Scanner;

public class _1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int width = 1000; // x축
		int height = 1000; // y축			
		
		width = x<w-x ? x : w-x;
		height = y<h-y ? y : h-y;
		System.out.println(width<height ? width : height);
	}
}
