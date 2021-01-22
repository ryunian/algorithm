package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15552 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		for(int i=0;i<a;i++){
			StringTokenizer b = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(b.nextToken());
			int y = Integer.parseInt(b.nextToken());
			int z = x+y;
			bw.write(Integer.toString(z)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
