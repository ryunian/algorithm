package sort;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		heapSort(arr,0,size-1);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] heapSort(int[] arr, int i, int j) {
		
		
		return arr;
	}
}
