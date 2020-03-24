import java.util.Arrays;
import java.util.Scanner;

public class _2750_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] arr = new int[x];
		for(int i=0; i<x; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("정렬 하기전 : " +Arrays.toString(arr));
//		selection(arr);
		insertion(arr);
		System.out.println("Sort : "+Arrays.toString(arr));
	}
	// 제일 큰것(작은것)을 찾아서 정렬
	private static int[] selection(int[] array) {
		int[] arr = array;
		int size = arr.length;
		for(int i=0; i<size;i++) {
			int x = 0;
			for(int j=1; j<size-i;j++) {
				if(arr[x]<arr[j]) x=j;
			}
			int swap = arr[x];
			arr[x] = arr[size-i-1];
			arr[size-i-1] = swap;			
		}
		return arr;
	}

	private static int[] insertion(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int taget = i-1;
			int pivot = arr[i];
			
			while(taget >= 0 && pivot<arr[taget]) {
				arr[taget+1] = arr[taget];
				taget--;
			}
			arr[taget+1] = pivot;			
		}		
		return arr;
	}
}