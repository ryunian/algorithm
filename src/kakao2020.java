import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kakao2020 {
	public static int result(String[] x){
		int a = x.length/2;
		
		return 1;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String[] x = new String[a.length()];
		x = a.split("");
		result(x);
		for(String i : x){
			System.out.print(i+" ");
		}
	}

}
