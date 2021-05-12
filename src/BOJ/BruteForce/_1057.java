package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if(b > c){
            int tmp = b;
            b = c;
            c = tmp;
        }
        int num = 1;
        while (true){
            if(b % 2 == 1 && b + 1 == c){
                System.out.println(num);
                break;
            }else {
                b = b % 2 == 1 ? (b+1)/2 : b/2;
                c = c % 2 == 1 ? (c+1)/2 : c/2;
            }
            num++;
        }
    }
}
