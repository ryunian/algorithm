package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중국인의 나머지 정리
public class _6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int MaxNum = LCM(n,m);

            int num = x;
            while (num <= MaxNum){
                if((num % m == 0 ? m : num % m) == y){
                    break;
                }
                num += n;
            }
            System.out.println(num > MaxNum ? -1 : num);
        }
    }

    // 최소공배수
    private static int LCM(int x, int y){
        return x * y / GCD(x,y);
    }

    // 최대공약수
    // 유클리드 호제법
    private static int GCD(int x, int y){
        if(x < y ) return GCD(y, x);
        return y == 0 ? x : GCD(y, x%y);
    }
}
