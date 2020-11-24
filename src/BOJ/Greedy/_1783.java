package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class _1783 {
    public static void main(String[] args) throws IOException {
        // Scanner 사용했을 경우 시간 112 ms , 메모리 : 11632kb
        // bufferedReader / Writer 사용했을 경우 시간 80ms , 메모리 : 11632kb
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()); // 세로
        int y = Integer.parseInt(st.nextToken()); // 가로
        br.close();

        int result;
        if (x == 1) {
            result = 1;
        }
        else if (x == 2) {
            int z = y/2 + y%2;
            result = Math.min(z,4);
        } else {
            if(y<5) result = y;
            else if(y<6) result = y-1;
            else result = y-2;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.close();
    }
}
