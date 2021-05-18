package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] x = br.readLine().split(" ");
                if(map.get(x[1]) == null){
                    map.put(x[1], 1);
                }else{
                    map.put(x[1], map.get(x[1]) + 1);
                }
            }
            int res = 1;
            for (String key : map.keySet()) {
                res *= map.get(key) + 1;
            }
            System.out.println(res -1);
        }
    }
}
