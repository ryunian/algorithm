package sort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr,0,num-1);
		System.out.println("Result : \n" + Arrays.toString(arr));
	}

	public static int[] quickSort(int[] arr,int p,int r) {
		if(p<r) {
			// 분할
			int q = partition(arr,p,r);
			// 왼쪽부분 정렬
			quickSort(arr,p,q-1);
			// 오른쪽부분 정렬
			quickSort(arr,q+1,r);
		}
		return arr;
	}

	private static int partition(int[] arr, int p, int r) {
		// 피봇을 가장 마지막의 숫자로 지정
		int pivot = arr[r];
		int swap;
		int i = p;
		/*
		int i = p - 1;
		 */
		for(int j=p; j<r;j++) {
			if(arr[j] <= pivot) {
				// 피봇보다 작은수를 스왑
				swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;
				// 스왑해야할 위치 +1
				i++;
				/*
				int swap = arr[++i];
				arr[i] = arr[j];
				arr[j] = swap;
				*/
			}
		}
		/*
		int swap = arr[r];
		arr[r] = arr[i+1];
		arr[i+1] = swap;
		return i+1;
		*/
		
		// 피봇위치를 피봇보다 첫번째로 큰 숫자 앞으로 변경
		arr[r] = arr[i];
		arr[i] = pivot;
		System.out.println(Arrays.toString(arr)+" pivot = "+pivot);
		return i;
	}
}
// 31 8 48 73 11 3 20 29 65 15
