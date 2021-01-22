package BOJ.Sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class _11651 {
	private static class Number implements Comparable<Number>{
		int a;
		int b;
		public Number(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Number o) {
			if(this.b < o.b) {
				return -1;
			}else if(this.b == o.b){
				if(this.a < o.a) {
					return -1;
				}else if(this.a == o.a) {
					return 0;
				}else {
					return 1;
				}
			}else return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Number[] arr = new Number[num];
		for(int i=0; i<num; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new Number(x,y);
		}
		Collections.sort(Arrays.asList(arr));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		for(Number i : arr) {
			bw.write(i.a+" "+i.b+"\n");
		}
		bw.flush();
	}
}
