package programmers;

import java.util.Arrays;

public class progrmers {
	  public static long solution(long n) {
	      long answer = 0;
	      String x = Integer.toString((int) n);
	      String[] y = x.split("");
	      int[] nums = Arrays.asList(y).stream().mapToInt(Integer::parseInt).toArray();
	      for(int i = 0 ; i < nums.length-1 ; i++) {
				for(int j = 0; j < nums.length-1-i; j++) {
					if(nums[j]<nums[j+1]) {
						int a = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = a;
					}
				}
	      }
	      String result = "";
	      for(int i=0; i< nums.length; i++) {
	    	  result += nums[i];
	      }
	      return Long.parseLong(result);
	  }
	  public static void main(String[] args) {
		  int n = 118372;		  
		  System.out.println(solution(n));
	}
}