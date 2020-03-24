package sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	static Scanner sc = new Scanner(System.in);
	static int leng = sc.nextInt();
	static int[] result = new int[leng];
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int[] arr = new int[leng];
		for(int i=0;i<leng;i++) {
			arr[i] = sc.nextInt();
		}
		mergeSort(arr,0,arr.length-1);
		for(int i : arr) {
			System.out.print(i+" ");
		}		
	}
	public static int[] mergeSort(int[] arr,int start, int last) {
		int middle;
		if(start<last) {
			middle = (start+last)/2;
			mergeSort(arr,start,middle);
//			System.out.println("앞부분  "+ Arrays.toString(arr));
			mergeSort(arr,middle+1,last);
//			System.out.println("뒷부분  "+ Arrays.toString(arr));
			return merge(arr,start,middle,last);
		}		
		return arr;
	}
	// start = 왼쪽부분 시작위치
	// middle = 왼쪽부분 마지막위치
	// middle+1 = 오른쪽부분 시작위치
	// last = 오른쪽부분 마지막위치
	public static int[] merge(int[] arr, int start, int middle, int last) {
//		int i = start; // 첫번째 부분집합의 시작위치
//		int j = middle+1; // 두번째 부분집합의 시작위치
//		int k = start; // 저장할 위치
		int i = start;
		int j = middle+1;
		int k = 0; // start로 해도 된다.
		
		
		// 시작위치가 중앙보다 작고 , 두번째 시작위치가 마지막보다 작을경우
		while (i<=middle && j<=last) {
			// 왼쪽이 오른쪽보다 작을경우
			if(arr[i]<=arr[j]) {
				// 새 배열에 왼쪽 삽입
				result[k] = arr[i];
				// 왼쪽 index+1
				i++;				
			// 오른쪽이 왼쪽보다 작을경우
			}else {
				// 새 배열에 오른쪽 삽입
				result[k] = arr[j];
				// 오른쪽 index+1
				j++;
			}
			// 새배열의 삽입위치 +1
			k++;		
		}
		
		/*
		// 2번쨰 방법
		// 왼쪽 부분 배열이 남은 경우  
		if(i>middle) {
			for(int t=j;t<=last;t++,k++) {
				result[k] = arr[t];
			}
		// 오른쪽 부분 배열이 남은 경우
		}else {
			for(int t=i;t<=middle;t++,k++) {
				result[k] = arr[t];
			}
		}
		// result를 arr에 넣어준다.			
		for(int t=start;t<=last;t++) {
			arr[t] = result[t];
		}	
		*/
		while(i<=middle) {
			result[k++] = arr[i++];
		}
		while(j<=last) {
			result[k++] = arr[j++];
		}
		i = start;
		k = 0; // start로 해도 된다				
		while(i<=last) {
			arr[i++] = result[k++];
		}
		System.out.println(Arrays.toString(result));
		System.out.println();
		return arr;
	}
}
// 31 3 65 73 8 11 20 29 48 15