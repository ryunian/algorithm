package complete;

import java.util.Scanner;

public class _2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x="",y="";
		String[] a = sc.next().split("");
		String[] b = sc.next().split("");
		for(int i=a.length-1; i>=0; i--) {
			x += a[i];
		}
		for(int i=b.length-1; i>=0; i--) {
			y += b[i];
		}
		if(Integer.parseInt(x) > Integer.parseInt(y)) {
			System.out.println(x);
		}else {
			System.out.println(y);
		}
	}
}
