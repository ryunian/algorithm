import java.util.Scanner;

public class _3009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] x = new String[3];
		String[] y = new String[3];
		String a = null,b = null;
		for(int i=0; i<3; i++) {
			x[i] = sc.next();
			y[i] = sc.next();			
		}
		if(x[0].equals(x[1])) a = x[2];
		else if(x[1].equals(x[2])) a = x[0];
		else if(x[0].equals(x[2])) a = x[1];
		
		if(y[0].equals(y[1])) b = y[2];
		else if(y[1].equals(y[2])) b = y[0];
		else if(y[0].equals(y[2])) b = y[1];
		
		System.out.println(a+" "+b);
		
		
		
		
	}
}
