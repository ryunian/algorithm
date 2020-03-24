import java.util.Scanner;

public class _1697 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int time = 0;
		while(true){
			if(a<b){
				if(b/2 > a){
					a *=2;
				}
			}else{
				
			}
			
			time++;
			System.out.println(time);
			if(a==b) {
				System.out.println(time);
				break;
			}
		}
	}
}
