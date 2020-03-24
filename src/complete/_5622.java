import java.util.Scanner;

public class _5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] x = sc.next().split("");
		int result = 0;
		for(int i=0; i<x.length; i++) {			
			int a = x[i].charAt(0)-64;
			result += 1;
			if(0<a && a<4) {
				result += 2;
			}else if(4<=a && a<7) {
				result += 3;
			}else if(7<=a && a<10) {
				result += 4;
			}else if(10<=a && a<13) {
				result += 5;
			}else if(13<=a && a<16) {
				result += 6;
			}else if(16<=a && a<20) {
				result += 7;
			}else if(20<=a && a<23) {
				result += 8;
			}else if(23<=a && a<27) {
				result += 9;
			}
		}
		System.out.println(result);
	}
}

// UNUCIC  868242