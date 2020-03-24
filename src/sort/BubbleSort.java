package sort;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int leng = sc.nextInt();
		int[] arr = new int[leng];
		for(int i=0;i<leng;i++) {
			arr[i] = sc.nextInt();
		}
		bubbleSort(arr);
		for(int i : arr) {
			System.out.print(i+" ");
		}			
	}
	public static int[] bubbleSort(int[] arr) {
		// 1개가 남앗을시 비교를 안해도 되기 떄문에 arr.length-1을 한다
		for(int i = 0 ; i < arr.length-1 ; i++) {
			// 가장오른쪽은 1회 비교가 끝날시 제외시켜줘야 하기 때문에 -i를 시켜줘야한다.
			for(int j = 0; j < arr.length-1-i; j++) {
				// 현재 배열이 다음배열보다 클경우
				if(arr[j]>arr[j+1]) {
					int x = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = x;
				}
			}
			for(int z : arr) {
				System.out.print(z+" ");
			}
			System.out.println();
		}		
		return arr;
	}
}
