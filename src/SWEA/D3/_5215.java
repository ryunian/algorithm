package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            String num = br.readLine();
            char[] target = num.toCharArray();
            char[] arr = new char[target.length];
            Arrays.fill(arr, '0');

            int res = 0;
            for (int j = 0; j < target.length; j++) {
                if(arr[j] != target[j]){
                    for (int k = j; k < target.length; k++) {
                        arr[k] = arr[k] == '0' ? '1' : '0';
                    }
                    res++;
                }
            }
            sb.append("#").append(i).append(" ").append(res).append("\n");
        }
        System.out.print(sb.toString());
    }
}
