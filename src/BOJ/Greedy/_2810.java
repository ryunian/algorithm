package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String m = br.readLine();
        String[] arr = m.split("");

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if("S".equals(arr[i])){
                cnt++;
            }else if("L".equals(arr[i])){
                i++;
                cnt++;
            }
        }
        System.out.println(cnt > n ? n : cnt);
    }
}
