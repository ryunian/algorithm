import java.util.Scanner;

public class _1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] y = new int[x];
		int z = 0;
		for(int i=0;i<x;i++){
			y[i] = sc.nextInt();
			if(z<y[i]) z=y[i];
		}
		double a= 0;
		for(double i : y){
			a += i*100/z;
		}
		System.out.print(a/x);
	}

}
