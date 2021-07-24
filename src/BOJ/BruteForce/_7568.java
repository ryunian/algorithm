package BOJ.BruteForce;

import java.util.Scanner;

public class _7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] weight = new int[x];
		int[] height = new int[x];
		for(int i=0; i<x; i++) {
			weight[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		for(int i=0; i<x; i++) {
			int a=1;
			for(int j=0; j<x; j++) {
				if(i==j) continue;
				if(weight[i]<weight[j] && height[i]<height[j]) {					
					a++;
				}
			}
			System.out.println(a);
		}
	}
}
