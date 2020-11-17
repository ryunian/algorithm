package complete;

import java.util.Scanner;

public class _3053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		double euclid = x * x * Math.PI;
		double taxi = x*x*2;
		System.out.printf("%.6f\n",euclid);
		System.out.printf("%.6f",taxi);
		
	}
}
