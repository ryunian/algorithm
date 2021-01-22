package BOJ.Sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;



public class _10814 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		String[] arr2 = new String[num]; 
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = sc.next();
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr2));
		int[] count = new int[201];
		for(int i=0; i<num; i++) {
			count[arr[i]] ++;
		}
//		System.out.println(Arrays.toString(count));
		for(int i=1; i<201; i++) {
			count[i] += count[i-1];
		}
//		System.out.println(Arrays.toString(count));
		int[] result = new int[num];
		String[] result2 = new String[num];
		for(int i=num-1; i>=0; i--) {
			int x = --count[arr[i]];
			result[x] = arr[i];
			result2[x] = arr2[i];
		}
//		System.out.println(Arrays.toString(result));
//		System.out.println(Arrays.toString(result2));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<num; i++) {
			bw.write(result[i]+" "+result2[i]+"\n");
		}
		bw.flush();
		
	}
}
