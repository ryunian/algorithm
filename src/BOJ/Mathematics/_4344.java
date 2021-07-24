package BOJ.Mathematics;

import java.util.Scanner;

public class _4344 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();				
		for(int i=0;i<x;i++){
			int num = 0;
			int count = 0;
			int y = sc.nextInt();
			double[] a = new double[y];
			for(int j=0;j<y;j++){
				double b = sc.nextInt();
				num += b;
				a[j] = b;
			}
			for(int k=0;k<y;k++){
				if(a[k]>num/y) count++;
			}
			double result = count*100/(double)y;
			double res = Math.round(result*1000);
			System.out.printf("%.3f",res/1000);
			System.out.println("%");
		}
	}
}
