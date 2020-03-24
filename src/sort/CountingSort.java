package sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CountingSort {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		int[] arr2 = new int[num];
//		for(int i=0; i<num; i++) {
//			arr2[i] = sc.nextInt();
//		}
		int[] arr = {31, 8, 48, 73, 11, 3, 20, 29, 65, 15};
		int[] result = counting(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<result.length;i++) {
			sb.append(result[i]+"\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());		
		bw.flush();
		bw.close();
	}

	private static int[] counting(int[] arr) {
		// arr 초기 배열
		// temp 카운팅을 하기위한 임시배열
		// result 정렬이된 배열
		
		int[] result = new int[arr.length];
		
//		// temp 배열크기찾기
//		int max = 0;
//		for(int i=0; i<arr.length; i++) {
//			if(max<arr[i]) max = arr[i];
//		}
//		int[] temp = new int[max+1];
		int[] temp = new int[10001];
		// 카운팅
		for(int i = 0; i<arr.length; i++) {
			temp[arr[i]]++;
		}
//		System.out.println(Arrays.toString(temp));
		
		// 누적합계산
		int a = temp[0];
		for(int i=1; i<temp.length; i++) {
			if(temp[i] == 0) continue;
			temp[i] = temp[i] + a;
			a = temp[i];
		}
//		System.out.println(Arrays.toString(temp));
		
		// 정렬
		for(int i=arr.length-1; i>=0; i--) {
			int x = --temp[arr[i]];
			result[x] = arr[i];			
		}
//		System.out.println(Arrays.toString(result));
		return result;
	}
}
