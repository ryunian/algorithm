package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        int max = b.length - a.length;
        int idx = 0;
        int res = 0;
        while (idx <= max) {
            int tmp = 0;
            for (int i = 0; i < a.length; i++) {
                int j = idx + i;
                if(a[i] == b[j]) tmp++;
            }
            res = Math.max(res, tmp);
            idx++;
        }
        System.out.println(b.length - max - res);
    }
}
