package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2164_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 1;
        while (n > x << 1){
            x = x << 1;
        }
        if(n == 1){
            System.out.println(1);
        }else {
            System.out.println((n - x) * 2);
        }
    }
}
