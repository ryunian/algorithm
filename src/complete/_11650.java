import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Number implements Comparable<Number>{
	int a;
	int b;
	public Number(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Number o) {
		if(this.a < o.a) {
			return -1;
		}else if(this.a == o.a) {
			if(this.b < o.b) {
				return -1;
			}else if(this.b == o.b) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 1;
		}
	}
}

public class _11650 {
//	static int[] temp;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		temp = new int[num];
//		List<Number> number = new ArrayList<>();
		Number[] number2 = new Number[num];
		for(int i=0; i<num; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
//			number.add(new Number(x,y));
			number2[i] = new Number(x,y);
		}
//		Collections.sort(number);
		Collections.sort(Arrays.asList(number2));
//		System.out.println("-----------");
//		for(int i=0; i<number.size();i++) {
//			System.out.println(number.get(i).a+" "+number.get(i).b);
//		}
//		System.out.println("-----------");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		for(Number i : number2) {
//			System.out.println(i.a+" "+i.b);
			bw.write(i.a+" "+i.b+"\n");		
		}
		bw.flush();
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		mergesort(a,0,num-1);
//		mergesort(b,0,num-1);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		int[] result = new int[num];
		
	}

//	private static void mergesort(int[] arr, int start, int end) {
//		int middle;
//		if(start<end) {
//			middle = (start+end)/2;
//			mergesort(arr,start,middle);
//			mergesort(arr,middle+1,end);
//			sort(arr,start,middle,end);
//		}
//		
//	}
//
//	private static void sort(int[] arr, int start, int middle, int end) {
//		int i = start;
//		int j = middle+1;
//		int k = 0;
//		while(i<=middle && j<=end) {
//			if(arr[i]<=arr[j]) {
//				temp[k++] = arr[i++];				
//			}else {
//				temp[k++] = arr[j++];
//			}
//		}
//		while(i<=middle) {
//			temp[k++] = arr[i++];
//		}
//		while(j<=end) {
//			temp[k++] = arr[j++];
//		}
//		i = start;
//		k = 0;
//		while(i<=end) {
//			arr[i++] = temp[k++];
//		}
//	}
}
