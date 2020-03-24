package sort;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int leng = sc.nextInt();
		int[] arr = new int[leng];
		for(int i= 0;i<leng;i++) {
			arr[i] = sc.nextInt();
		}
		selection(arr);
		System.out.println("정렬완료");
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	public static int[] selection(int[] arr) {
		int a,min;
		for(int i = 0 ; i<arr.length-1; i++) {
			System.out.print(i+1+"번쨰  ");
			min = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min = j;
				}
			}
			a = arr[i];
			arr[i] = arr[min];
			arr[min] = a;
			for(int x : arr) {
				System.out.print(x+" ");
			}
			System.out.println();			
		}
		return arr;		
	}	
}
