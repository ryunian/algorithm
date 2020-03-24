import java.util.Scanner;

public class _1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] x = sc.nextLine().split(" ");
		int size = 0;
		for(int i=0; i<x.length; i++) {
			if("".equals(x[i]) == false) {
				size++;
			}
		}
		System.out.println(size);
	}
}
