package BOJ.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			list.add(sc.nextInt());
		}
//		quicksort(arr,0,num-1);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
	}

	private static void quicksort(int[] arr,int start, int end) {
		if(start<end) {
			int middle = partition(arr,start,end);
			quicksort(arr,start,middle-1);
			quicksort(arr,middle+1,end);
		}
	}

	private static int partition(int[] arr,int start,int end) {
		int pivot = arr[end];
		int swap;
		int x = start;
		for(int i=start; i<arr.length; i++) {
			if(arr[i]<pivot) {
				swap = arr[i];
				arr[i] = arr[x];
				arr[x] = swap;
				x++;
			}
		}		
		arr[end] = arr[x];
		arr[x] = pivot;
		return x;
	}
}
