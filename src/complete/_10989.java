package complete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int num = Integer.parseInt(br.readLine());
		int size = 10001;
		int[] temp = new int[size];
		for(int i=0; i<num; i++) {
			int x = Integer.parseInt(br.readLine());
			temp[x]++;
		}
//		System.out.println(Arrays.toString(temp));
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<size;i++) {
			if(temp[i]==0) continue;
			for(int j=0; j<temp[i];j++) {
				sb.append(i+"\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
