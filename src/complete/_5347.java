import java.util.Scanner;
public class _5347 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			long a = in.nextInt();
			long b = in.nextInt();
			long result=0;
			for(long j=1;j<=a*b;j++){
				result = a*j;
				if(result%a==0 & result%b==0){
					break;
				}
			}
			System.out.println(result);
		}								
	}
}
