package BOJ.Backtracking;

import java.util.Scanner;

public class _15649 {
	static boolean[] check;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		check = new boolean[x+1];
		temp = new int[y];
		sequence(x,y,0);
		System.out.println(sb);
	}

	private static void sequence(int x, int y, int z) {
		if(y==z) {
//			System.out.println(Arrays.toString(temp));
			for(int i=0; i<y;i++) {
				sb.append(temp[i]+" ");
			}
			sb.append("\n");
			return;
		}				
		
		for(int i=1; i<=x; i++) {
			if(!check[i]) {
				check[i] = true;
				temp[z] = i;
				sequence(x, y, z+1);
				check[i] = false;
			}
		}		
	}
}
