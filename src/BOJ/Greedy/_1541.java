package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String[] a = x.split("-");
        int[] b = new int[a.length];
        int c = 0;
        for(int i= 0; i<a.length; i++){
            String[] plus = a[i].split("\\+");
            for(int j = 0; j<plus.length;j++){
                b[i] += Integer.parseInt(plus[j]);
            }
            if(i!=0) c += b[i];
        }
        System.out.println(b[0]-c);
    }
}
