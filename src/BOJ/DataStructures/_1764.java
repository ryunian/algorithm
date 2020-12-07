package BOJ.DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1764 {
    public static void main(String[] args) throws IOException {
        // 이분탐색, 정렬 관련 문제지만 hashmap을 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        Map<String, Integer> result = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            String x = br.readLine();
            if(map.get(x) != null){
                cnt++;
                result.put(x,i);
            }
        }
        System.out.println(cnt);
        Iterator it = result.keySet().iterator();
        while(it.hasNext()){
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
