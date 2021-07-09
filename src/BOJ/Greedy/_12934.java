package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12934 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long tmp = 0;
        int cnt = 0;
        while (tmp < a+b){
            tmp += ++cnt;
        }

        if(tmp == a+b){
            int res = 0;
            while (a > 0){
                if(a >= cnt){
                    a -= cnt;
                    res++;
                }
                cnt--;
            }
            System.out.println(res);
        }else{
            System.out.println(-1);
        }
    }
}
