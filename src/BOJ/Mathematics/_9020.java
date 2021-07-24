package BOJ.Mathematics;

import java.util.Scanner;

public class _9020 {
	public static void main(String[] args) {
		int size = 10000+1;
		int[] arr = new int[size];
		for(int i=2;i<size;i++) {
			arr[i] = i;
		}
		for(int i=1; i<size; i++) {
			if(arr[i]==0) continue;
			for(int j=i+i; j<size; j+=i) {
				arr[j] = 0;
			}
		}
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();		
		for(int i=0; i<num; i++) {
			int x = sc.nextInt();
			int[] result = goldbach(x,arr);
			System.out.println(result[0]+" "+result[1]);
		}
	}

	private static int[] goldbach(int x,int[] arr) {
		int[] result = new int[2];
		for(int i=x/2+1; i>=2; i--) {
			if(arr[i]==0) continue;
			for(int j=x/2-1; j<x; j++) {
				if(arr[j]==0) continue;
				if(arr[i]+arr[j]==x) {					
					result[0] = i<j ? i : j; 
					result[1] = i<j ? j : i;
					return result;
				}
			}
		}
		return result;
	}
}
