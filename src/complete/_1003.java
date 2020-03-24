// �Ǻ���ġ ����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int[] result = new int[100];
		result[1] = 1;		
		for(int i=0;i<x;i++){
			int y = Integer.parseInt(br.readLine());
			for(int j=2;j<=y+1;j++){
				result[j] = result[j-1] + result[j-2];
			}
			if(y==0) System.out.println(result[y+1]+" "+result[y]);
			else System.out.println(result[y-1]+" "+result[y]);
		}
	}
}
