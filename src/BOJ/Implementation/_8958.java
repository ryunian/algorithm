package BOJ.Implementation;

import java.util.Scanner;

public class _8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();		
		for(int i=0;i<a;i++){
			String x = sc.next();
			int count = 0;
			int result = 0;
			for(int j=0;j<x.length();j++){
				if(x.charAt(j)=='O'){
					count++;
					result +=count;
				}else count = 0;
			}
			System.out.println(result);
		}
	}

}
