package BOJ.BruteForce;

import java.util.Scanner;

public class _2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] a = new int[y];
		for(int i=0;i<x;i++){
			a[i]= sc.nextInt();			
		}
		
		int result=0;
		for(int i=0;i<x-2;i++){
			for(int j=i+1;j<x;j++){
				for(int k=j+1;k<x;k++){
					int sum = a[i]+a[j]+a[k];
					if(sum<=y & result<sum) result = sum; 
				}
			}
		}
		System.out.println(result);
	}
}
