import java.util.Scanner;

public class _1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int num=665;
		int count=0;
		while(true){
			if(String.valueOf(num).indexOf("666") != -1) count++;
			if(count==x) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}
