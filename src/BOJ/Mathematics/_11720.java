package BOJ.Mathematics;

import java.util.Scanner;

public class _11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String num = sc.next();
		String[] arr = new String[size];
		arr = num.split("");
		int result = 0;
		for(int i=0; i<size; i++) {
			result += Integer.parseInt(arr[i]);
		}
		System.out.println(result);
	}	
}
