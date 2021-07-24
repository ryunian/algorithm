package BOJ.Implementation;

import java.util.Scanner;

public class _2941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		int count = 0;
		for(int i=0; i<x.length(); i++) {
			if(x.substring(i, i+1).equals("c")) {
				if(i<x.length()-1 && x.substring(i+1, i+2).equals("=")) {
					i++;
				}else if(i<x.length()-1 && x.substring(i+1, i+2).equals("-")) {
					i++;
				}
			}else if(x.substring(i, i+1).equals("d")) {
				if(i<x.length()-1 && x.substring(i+1, i+2).equals("-")) {
					i++;
				}else if(i<x.length()-1 && x.substring(i+1, i+2).equals("z")) {
					if(i<x.length()-2 && x.substring(i+2, i+3).equals("=")) {
						i += 2;
					}
				}
			}else if(x.substring(i, i+1).equals("l")) {
				if(i<x.length()-1 && x.substring(i+1, i+2).equals("j")) {
					i++;
				}
			}else if(x.substring(i, i+1).equals("n")) {
				if(i<x.length()-1 && x.substring(i+1, i+2).equals("j")) {
					i++;
				}
			}else if(x.substring(i, i+1).equals("s")) {
				if(i<x.length()-1 && x.substring(i+1, i+2).equals("=")) {
					i++;
				}
			}else if(x.substring(i, i+1).equals("z")) {
				if(i<x.length()-1 && x.substring(i+1, i+2).equals("=")) {
					i++;
				}
			}						
			count++;
		}
		System.out.println(count);
		
	}
}
// ljes=njak  6