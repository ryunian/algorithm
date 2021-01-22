package BOJ.etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10039 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 5;
		int a = 0;
		for(int i=0;i<x;i++){
			int b = Integer.parseInt(br.readLine());
			if(b<40) b = 40;
			a +=  b;
		}
		System.out.println(a/x);
		
	}
	
}
