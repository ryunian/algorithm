package complete;

import java.util.Arrays;
import java.util.Scanner;

public class _4948 {
	public static void main(String[] args) {
		int size = 123456*2 +1;
		int[] arr = new int[size]; 
		for(int i=2; i < size; i++) {
			arr[i] = i;
		}
		// 에라토스테네스의 체 
		for(int i=1; i<size; i++) {
			if(arr[i]==0) continue;
			for(int j=i+i; j<size; j+=i) {
				arr[j] = 0;
			}
		}
//		System.out.println(Arrays.toString(arr));
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			int count = 0;
			int x = sc.nextInt();
			if(x==0) break;						
			for(int i=x+1;i<=x*2; i++) {
				if(arr[i] != 0) count++;
			}			
			System.out.println(count);
		}
	}

//	private static void sosu(int x,ArrayList<Integer> list) {
//		long start = System.currentTimeMillis();
//		int count = 0;
//		for(int i=2; i<=(x*2); i++) {
//			for(int j=0; j<list.size(); j++) {
//				if(i % list.get(j) == 0) break;
//				if(j+1 == list.size()) {
//					list.add(i);
//				}
//			}
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("수행시간 : "+(end-start));
//		for(int i=x; i<=x*2; i++) {
//			if(list.indexOf(i) != -1) count++;
//		}
//		System.out.println(count);
//		
//	}
}
