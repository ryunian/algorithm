package BOJ.etc;// 효율적인 메모리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9517 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String[][] x = new String[n][2];
		int num = k;
		int boom = 0;
		for(int i=0;i<n;i++){
			String a = br.readLine();
			x[i] = a.split(" ");
			boom += Integer.parseInt(x[i][0]);
			if(boom >= 210) break;
			if(k>8) k = 1;		
			if(x[i][1].equals("T")) k++;
		}
		System.out.println(k);		
	}

}
