import java.util.Arrays;
import java.util.Scanner;

public class _1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		findNum(x);
	}

	private static void findNum(int x) {
		if(x==1000) x= 999;
		int count;
		if(x>=100) {
			count = 99;
			for(int i = 100; i <= x ; i++) {
				int j = i;
				int k = 0;
				int[] arr = new int[3];
				while(j > 0) {
//					System.out.print(j%10+"  ");
					arr[k++] = j%10;
					j = j/10;					
				}
				if(arr[0] - arr[1] == arr[1] - arr[2] ) {
//					System.out.print(i+"번째 = " +Arrays.toString(arr)+"  \n");
					count++;
				}
//				System.out.println();
			}
//			System.out.println();
			System.out.println(count);
		}else {
			count = x;
			System.out.println(count);
		}				
	}
}
