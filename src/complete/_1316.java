import java.util.Arrays;
import java.util.Scanner;

public class _1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		char[] x = new char[num];
		int count = 0;
		for(int i=0; i<num; i++) {
			x = sc.next().toCharArray();
			count += checker(x);
		}
		System.out.println(count);
	}
// h a p p y 
	private static int checker(char[] x) {
		int[] alpha = new int[26];
		int a = 0;
		for(int i=0; i<x.length; i++) {
			alpha[x[i]-97]++;
			if(i!=x.length-1 && x[i] == x[i+1]) {
				alpha[x[i]-97]--;
			}
			if(alpha[x[i]-97] == 2) return 0;
		}
//		System.out.println(Arrays.toString(alpha));		
		return 1;
	}
}
