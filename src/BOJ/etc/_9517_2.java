package BOJ.etc;// ¼ôÄÚµù
import java.util.Scanner;
public class _9517_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int n = in.nextInt();
		int boom = 0;
		for(int i=0;i<n;i++){
			boom += in.nextInt();
			if(boom >= 210) break;
			if(k>8) k = 1;		
			if(in.next().equals("T")) k++;
		}
		System.out.println(k);		
	}
}
