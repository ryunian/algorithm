package complete;

import java.util.Scanner;

public class _2447 {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		arr = new char[num][num];
		star(0,0,num);
		view();
	}
	private static void view() {
		StringBuilder sb = new StringBuilder();
		for(char[] i : arr) {
			for(char j : i) {
				if(j!='*') {
					// char 배열에서 초기화하지않을시 공백이 실제론 null이기떄문
					sb.append(" ");
				}else
					sb.append(j);				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void star(int y, int x, int num) {
		// num이 1일경우 더 이상 분할하지 않음
		if(num==1) {
			arr[y][x] ='*';
			return;
		}
		int div = num/3;		
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1) {
					// i와 j가 1일 경우 공백 
					continue;
				}else {
					star(y+(i*div),x+(j*div) ,div);
				}
			}
		}
	}
}
