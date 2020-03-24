package sort;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int leng = sc.nextInt();
		int[] arr = new int[leng];
		for(int i=0;i<leng;i++) {
			arr[i] = sc.nextInt();
		}
		insertionSort(arr);
		view(arr);
	}
	public static void view(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static int[] insertionSort(int[] arr) {
		int taget,pivot;
		for(int i = 1; i < arr.length; i++) {
			// 비교할 대상
			taget = i-1;
			// 기준
			pivot = arr[i];
			// taget이 0 미만이 되면 안된다, 0미만일시 뒤 조건은 필요없으므로 &&으로 한다
			while(taget >= 0 && arr[taget] > pivot ) {
				// 비교할 대상이 더 클시 오른쪽으로 옮긴다
				arr[taget+1] = arr[taget];
				// 비교할 대상 그왼쪽에 있는 걸로 바꾼다.
				taget--;
			}
			arr[taget+1] = pivot;
			view(arr);
		}
		
		return arr;
	}
}
// 10
// 3 31 48 73 8 11 20 29 65 15