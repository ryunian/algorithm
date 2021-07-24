package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = Integer.parseInt(arr[i]);
            val += (int) Math.pow(x , 2);
        }
        System.out.println(val%10);
    }
}
