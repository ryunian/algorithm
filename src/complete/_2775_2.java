package complete;

import java.util.Scanner;

public class _2775_2 {
	static int[][] arr = new int[15][14];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			apart(k+1,n);
		}
	}

	private static void apart(int k, int n) {
		for(int i=0; i<k; i++) {
			for(int j=0; j<n; j++) {
				if(i==0) {
					arr[i][j] = j+1;
				}else if(j==0) {
					arr[i][j] = 1;
				}else {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}				 
			}
		}
		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println(arr[k-1][n-1]);
	}
	
}
