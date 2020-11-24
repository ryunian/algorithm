package BOJ.Greedy;

import java.util.Scanner;

public class _11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] c = new int[a];
		for(int i=0;i<a;i++){
			c[i]  = sc.nextInt();
		}
		int count = 0;
		for(int i=a-1;i>=0;i--){
			if(b/c[i] != 0){
//				System.out.println(b);
//				System.out.println(c[i]);
				count += b/c[i];
				b = b%c[i];
			}
		}
		System.out.println(count);
	}

}
