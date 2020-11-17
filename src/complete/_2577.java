package complete;

import java.util.Scanner;

public class _2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int mul = a*b*c;
		String x = String.valueOf(mul);
		int[] y = new int[10];
		for(int i=0;i<x.length();i++){
			int z = Integer.parseInt(x.substring(i, i+1));
			y[z] += 1;
		}
		for(int i : y){
			System.out.println(i);
		}
	}
}
