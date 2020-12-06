package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            char[] x = br.readLine().toCharArray();
            if(x[0] == '0') break;
            sb.append(solve(x)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String solve(char[] x) {
        for (int i = 0, j = x.length-1; i < x.length; i++,j--) {
            if(x[i] != x[j]) return "no";
        }
        return "yes";
    }
}
