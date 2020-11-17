package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _1018 {
	static char[][] chess = { 
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}						
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int min = x*y;
		char[][] board = new char[x][y];
		for(int i=0;i<x;i++) {
			board[i] = sc.next().toCharArray();
		}
		for(int i=0;i<=x-8;i++) {
			for(int j=0;j<=y-8;j++) {
				int change = solution(board,i,j);
//				System.out.println("change = "+change);
				if(min>change) min = change;
//				System.out.println(min);
			}
		}
		System.out.println(min);
	}
	private static int solution(char[][] board, int a,int b) {
//		System.out.println("a="+a+"  b="+b);
		int count1 = 0;
		int count2 = 0;
		for(int i=a,i2=0;i2<8;i++,i2++) {
			for(int j=b,j2=0;j2<8;j++,j2++) {				
				if(board[i][j] == chess[i2][j2]) count1++;
				else if(board[i][j] != chess[i2][j2]) count2++;
			}
		}
		return count1<count2?count1:count2;
	}
}
