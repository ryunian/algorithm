package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int j = 0; j < n; j++) {
            TreeMap<Long, Integer> map = new TreeMap<>();
            int q = Integer.parseInt(br.readLine());
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String x = st.nextToken();
                Long y = Long.parseLong(st.nextToken());
                if("D".equals(x)){
                    if(map.isEmpty()) continue;
                    long z = y == 1 ? map.lastEntry().getKey() : map.firstEntry().getKey();
                    if(map.get(z) > 1){
                        map.put(z, map.get(z).intValue()-1);
                    }else{
                        map.remove(z);
                    }
                }else{
                    map.put(y, map.get(y) == null ? 1 : map.get(y)+1);
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastEntry().getKey()+ " "+ map.firstEntry().getKey());
            }
        }
    }
}
