package BOJ.Mathematics;

import java.util.Scanner;
public class _2869 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		int x = 0;
		if((V-B)%(A-B) != 0){
			x = (V-B)/(A-B) +1;
		}else{
			x = (V-B)/(A-B);
		}
		System.out.println(x);
	}
}
