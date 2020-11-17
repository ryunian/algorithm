package complete;

import java.util.Scanner;

public class _10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int result = 0;
		result = fibonachi(x);
		System.out.println(result);
	}

	private static int fibonachi(int x) {
		if(x>1) {
			x = fibonachi(x-2)+fibonachi(x-1);
		}				
		return x;
	}
}
