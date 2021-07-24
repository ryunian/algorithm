package BOJ.Mathematics;

import java.util.Scanner;

public class _1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int left = 1;
		int right = 1;
		int count = 1;
		boolean way = false;
		while(num>count) {			
//			if(left == 1 && way == false) {
//				right++;
//				way = true;
//			}else if(right == 1 && way == true) {
//				left++;
//				way = false;
//			}else if(way) {
//				left++;	right--;
//			}else if(!way){
//				left--;	right++;
//			}			
			if(way) {
				if(right == 1) {
					left++;	way = false;
				}else {
					left++;	right--;
				}
			}else{
				if(left == 1) {
					right++; way=true;
				}else {
					left--;	right++;
				}				
			}
			count++;
		}
//		System.out.println("RESULT = ");
		System.out.println(left+"/"+right);
	}
}
