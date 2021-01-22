package BOJ.String;

import java.util.Scanner;

public class _10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] x = sc.next().split("");
		String[] alpha = new String[26];
		
		for(int i=0; i<x.length; i++) {
			int ascii = 97;
			for(int j=0; j<alpha.length; j++) {
				if(ascii == (int) x[i].charAt(0)) {
					if(alpha[j] == "-1" | alpha[j] == null) {
						alpha[j] = ""+i;
					}					
				}
				else {
					if(alpha[j] == null) {
						alpha[j] = "-1";
					}
				}
				ascii++;
			}
		}
		for(String i : alpha) {
			System.out.print(i+ " ");
		}
	}
}
