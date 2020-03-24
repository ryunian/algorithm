import java.util.Arrays;
import java.util.Scanner;

public class _1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] x = sc.next().toUpperCase().split("");
		int[] alpha = new int[26];
		for(int i=0; i<x.length; i++) {
			int a = x[i].charAt(0) - 65;
			alpha[a] += 1;
		}
		int count = 0;
		int high = alpha[0];
		boolean overlap = false;
		for(int i=1; i<alpha.length; i++) {
			if(high < alpha[i]) {
				high = alpha[i];
				count = i;
				overlap = false;
			}else if(high == alpha[i]) {
				overlap = true;
			}
		}
		if(overlap) {
			System.out.println("?");
		}else {
			System.out.println((char)(count+65));
		}
	}
}
