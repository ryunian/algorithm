package BOJ.etc;

public class _4673 {
	public static boolean selfNumber(int x) {
		for(int i=1;i<x;i++) {
			
			int sum = i;
			int num = i;
			sum += num%10;
			while(num>=10) {								
				num = num/10;
				sum += num%10;
			}
			if(x == sum) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		for(int i=1; i<=10000; i++) {
			if(!selfNumber(i)) {
				System.out.println(i);
			}
		}		
	}
}
