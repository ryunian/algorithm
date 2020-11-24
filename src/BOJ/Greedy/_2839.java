package BOJ.Greedy;

import java.util.Scanner;
public class _2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int ct = 0;
		while(true){
			if(x%5==0){
				ct +=x/5;
				break;
			}
			x -=3;
			ct++;						
			if(x<3 & x != 0){
				ct = -1;
				break;
			}
			else if(x==0) break;
		}
		System.out.println(ct);
		
	}
}
