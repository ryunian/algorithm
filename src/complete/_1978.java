import java.util.Scanner;

public class _1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count=0;
		for(int i=0; i<num; i++) {
			int x = sc.nextInt();
			int sosu=0;
			for(int j=1; j<=x; j++) {
				if(x%j==0) {
					sosu++;
				}
				if(x==1 || sosu>2) break;
				if(j==x && sosu==2) count++;					
			}
		}
		System.out.println(count);
	}
}
