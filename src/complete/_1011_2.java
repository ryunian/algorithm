import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class _1011_2{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int dist, t = Integer.parseInt(in.readLine());
		StringBuilder res = new StringBuilder();
		String line[];
		while(t-->0){
			line = in.readLine().split(" ");
			dist = Integer.parseInt(line[1]) - Integer.parseInt(line[0]);
			res.append(warp(dist)+"\n");
			System.out.println(warp(dist));
		}
		out.write(res.toString());
		out.close();
		in.close();
	}
	
	private static long warp(int dist){
		long n, minN, powN, maxN, warpCount = 0;
		for(n=1;;n++){
			powN = n*n;
			minN = powN - n + 1;
			maxN = powN + 1 + n - 1;
			if(minN<=dist && dist<=maxN){
				if(minN<=dist && dist<=powN) warpCount = (n<<1) - 1;
				else warpCount = n<<1;
				break;
			}
		}
		return warpCount;
	}
}