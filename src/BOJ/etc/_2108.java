package BOJ.etc;

import java.util.Scanner;

public class _2108 {
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		result = new int[num];
		double sum = 0;
		for(int i=0; i<num; i++) {
			int n = sc.nextInt();
			arr[i] = n;
			sum += n;
		}
		// 병합정렬 실행
		mergesort(arr,0,num-1);
		
		
		int[] count = new int[num];
		int a = 1;
		int max=0;
		// 최빈값을 찾기위한 카운팅
		for(int i=0; i<num-1; i++) {
			if(arr[i] == arr[i+1] ) {
				if(max<a) max=a;
				count[i] = a;
				a++;
			}else {
				a=1;
			}
		}
		int b = 0;
		int mid = 0;
		// 최빈값 찾기
		for(int i=0; i<num; i++) {
			if(b==2) break;
			if(count[i]==max) {				
				mid = arr[i];
//				System.out.println("mid "+mid);
				b++;
			}
			
		}
//		System.out.println(Arrays.toString(count));
//		System.out.println(Arrays.toString(arr));
		// 산술평균 소수점에서 반올림
		System.out.printf("%.0f\n",sum/num);
		// 중앙값 
		System.out.println(arr[num/2]);
		// 최빈값 , 여러개 있을시 두번쨰로 작은값
		System.out.println(mid);
		// 범위
		System.out.println(arr[num-1]-arr[0]);
	}

	private static void mergesort(int[] arr, int start, int end) {
		int middle;
		if(start<end) {
			middle = (start+end)/2;
			mergesort(arr,start,middle);
			mergesort(arr,middle+1,end);
			
			merge(arr,start,middle,end);
		}
	}

	private static void merge(int[] arr, int start, int middle, int end) {
		// TODO Auto-generated method stub
		int a = start;
		int b = middle+1;
		int x = 0;
		while(a<=middle && b<=end) {
			if(arr[a]<=arr[b]) {
				result[x++] = arr[a++];
			}else {
				result[x++] = arr[b++];
			}
		}
		while(a<=middle) {
			result[x++] = arr[a++];
		}
		while(b<=end) {
			result[x++] = arr[b++];
		}
		a = start;
		x = 0;
		while(a<=end) {
			arr[a++]= result[x++];
		}
	}
}
