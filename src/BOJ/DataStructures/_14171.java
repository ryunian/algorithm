package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _14171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken().substring(0, 2);
            String b = st.nextToken();

            if(a.equals(b)) continue;
            String str = a+b;

            if(map.get(str) == null){
                map.put(str, 1);
            }else {
                map.put(str, map.get(str)+1);
            }

            str = b+a;
            if(map.get(str) != null){
                res += map.get(str);
            }
        }
        System.out.println(res);
    }


}
