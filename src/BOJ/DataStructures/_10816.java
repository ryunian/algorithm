package BOJ.DataStructures;

import java.io.*;
import java.util.*;

public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            // map.merge(x, 1, Integer::sum); 과 동일
            if(map.get(x) == null){
                map.put(x, 1);
            }else{
                map.put(x, map.get(x)+1);
            }
        }
//        System.out.println(map);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(map.get(x) == null){
                sb.append(0+" ");
            }else{
                sb.append(map.get(x)).append(" ");
            }
        }

        System.out.println(sb.toString());


    }
}
