import java.util.Scanner;

public class _11729 {
	static StringBuilder sb = new StringBuilder();
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		hanoi(x,1,2,3);
		System.out.println(result);
		System.out.println(sb);
	}

	private static void hanoi(int x, int a,int b, int c) {		
		if(x==1) {
			sb.append(a+" "+c+"\n");
			result++;
		}else {
			hanoi(x-1,a,c,b);
			sb.append(a+" "+c+"\n");
			result++;
			hanoi(x-1,b,a,c);
		}
	}
}
