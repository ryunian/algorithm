import java.util.Arrays;
import java.util.Scanner;

public class _1929 {
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] arr = new int[(y-x)/2+1];
		if(y>1) arr[0] = 2;		
		for(int i = 3; i<=y; i++) {
			int count = 0;
			while(arr[count] != 0) {
				if(i%arr[count] != 0 && arr[count+1]==0) {
					arr[count+1] = i;
				}else if(i%arr[count] == 0) {
					break;
				}
				count++;
			}
		}
		for(int i : arr) {
			if(i!=0) {
				System.out.println(i);
			}			
		}
		*/
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		for(int i=x; i<=y; i++) {
			for(int j=2; j<=i; j++) {
				if(i%j==0 && i!=j) break;
				if(j*j>i) {					
					System.out.println(i);
					break;
				}				
			}
		}
	}
}
