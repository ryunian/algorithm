import java.util.Arrays;
import java.util.Scanner;

public class _1427 {
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] x = sc.next().split("");
		int[] arr = new int[x.length];
		for(int i=0; i<x.length; i++) {
			arr[i] = Integer.parseInt(x[i]);
		}
		System.out.println(Arrays.toString(arr));
		result = new int[arr.length];
		mergesort(arr,0,x.length-1);
		String sort = "";
		for(int i=0; i<arr.length; i++) {
			sort += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sort);
	}

	private static void mergesort(int[] arr, int start, int last) {
		int middle;
		if(start<last) {
			middle = (start+last)/2;
			mergesort(arr,start,middle);
			mergesort(arr,middle+1,last);
			
			merge(arr,start,middle,last);
		}
		
	}

	private static void merge(int[] arr, int start, int middle, int last) {
		int i = start;
		int j = middle+1;
		int k = 0;
		while(i<=middle && j<=last) {
			// 오름차순으로 할시 arr[i]<=arr[j]
			if(arr[i]>=arr[j]) {
				result[k++] = arr[i++];
			}else {
				result[k++] = arr[j++];
			}
		}
		while(i<=middle) {
			result[k++] = arr[i++];
		}
		while(j<=last) {
			result[k++] = arr[j++];
		}
		i = start;
		k = 0;
		while(i<=last) {
			arr[i++] = result[k++];
		}
	}
}
