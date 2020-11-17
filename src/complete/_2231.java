package complete;

import java.util.Scanner;

public class _2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String x = sc.next();
		int x = sc.nextInt();
		long start = System.currentTimeMillis();
		for(int i = x/2; i<=x;i++) {
			if(i==x) System.out.println(0);
//			System.out.print(i+" ");
			String[] a = (""+i).split("");
			int sum = i;
			for(int j=0;j<a.length;j++) {
				sum += Integer.parseInt(a[j]);
			}
//			System.out.println(sum);
			if(sum==x) {
				System.out.println(i);
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (end-start));
	}
}
